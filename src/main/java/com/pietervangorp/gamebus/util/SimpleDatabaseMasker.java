package com.pietervangorp.gamebus.util;

import com.google.gson.Gson;
import com.pietervangorp.gamebus.util.config.ColumnMapping;
import com.pietervangorp.gamebus.util.config.ConfigurationModel;
import com.pietervangorp.gamebus.util.config.FlushTableConfig;
import com.sun.tools.javac.util.Pair;
import org.apache.commons.io.FileUtils;

import javax.json.JsonArray;
import java.io.*;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;

/**
 * Created by pvgorp on 28/12/2017.
 */
public class SimpleDatabaseMasker {
    private static final Logger logger = Logger.getLogger(SimpleDatabaseMasker.class.getName());

    private ConfigurationModel configurationModel;

    private Map<String, Pair<JsonArray,Integer>> cachedJSONrowsPerFile= new HashMap<String, Pair<JsonArray,Integer>>();// the int is for counting how far you were iterating in it, thereby enabling a graceful endless loop

    private int logStep=1;

    public static void main(String[] args) throws FileNotFoundException {
        if (args == null || args.length != 1) {
            System.err.println("USAGE ERROR: specify JSON file.");
            System.exit(1);// https://stackoverflow.com/questions/2434592/difference-in-system-exit0-system-exit-1-system-exit1-in-java
        }
        logger.info("args[0]: "+args[0]);

        SimpleDatabaseMasker masker= new SimpleDatabaseMasker(args[0]);

        masker.anonymize();

        return;
    }

    public SimpleDatabaseMasker(final String confModelFile) {

        try {
            configurationModel = new Gson().fromJson(
                    new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(confModelFile))),
                    ConfigurationModel.class);

            cacheFiles(configurationModel.getColumnMappings());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Other error", e);
        }
    }

    private void anonymize() {

        try {

            logStep("Connecting to DB...");
            Class.forName(configurationModel.getDatabaseConfig().getDriver());
            Connection con = DriverManager.getConnection(
                    configurationModel.getDatabaseConfig().getUrl(),
                    configurationModel.getDatabaseConfig().getUsername(),
                    configurationModel.getDatabaseConfig().getPassword());

            for (ColumnMapping columnMapping : configurationModel.getColumnMappings()) {
                String selectQuery;
                String updateQuery;
                if (columnMapping.isPreserveDuplicateValues()) {
                    // take 0 as dummy ID for the aggregate set of rows with the same value
                    selectQuery= "select distinct `"+columnMapping.getSrcColumn() +"` from `" + columnMapping.getSrcTable() + "`";
                } else { // each row its own unique new value
                    selectQuery= "select id,  `"+columnMapping.getSrcColumn() +"` from `" + columnMapping.getSrcTable() + "`";
                }
                logStep("Loading data of table "+columnMapping.getSrcTable()+" for handling property "+columnMapping.getSrcColumn() +"...");
                logger.info(selectQuery);

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(selectQuery);
                while (rs.next()) {

                    String whereValue= rs.getString(1), newValue= getNextValueFor(columnMapping);
                    if (columnMapping.isPreserveDuplicateValues()) { // merge duplicates, so do not consider IDs
                        updateQuery= "update `" + columnMapping.getSrcTable() + "` set `" + columnMapping.getSrcColumn() + "` = ? where `"+columnMapping.getSrcColumn() + "`= ?";
                        logger.fine(columnMapping.getSrcColumn() +": " + rs.getString(1) + ".");
                    } else { // do not merge duplicates, so use one update query per ID value
                        updateQuery= "update `" + columnMapping.getSrcTable() + "` set `" + columnMapping.getSrcColumn() + "` = ? where id = ? ";
                        logger.fine("ID: "+rs.getInt(1) + ", "+columnMapping.getSrcColumn() +": " + rs.getString(2) + ".");
                    }
                    PreparedStatement updatePrepared= con.prepareStatement(updateQuery);
                    updatePrepared.setString(1, newValue);
                    updatePrepared.setString(2, whereValue);
                    runUpdate(updatePrepared);

                    //updateQuery= MessageFormat.format(updateQuery,
                     //       new Object[] {whereValue, newValue});

                    //runUpdate(con, updateQuery);
                }
            }
            for (FlushTableConfig flushTableConfig : configurationModel.getFlushTableConfigs()) {
                logStep("Flushing data of table "+flushTableConfig.getTableName()+"...");
                String flushQuery= "truncate `"+flushTableConfig.getTableName()+"`"; // fastest, see https://stackoverflow.com/a/18272003
                runUpdate(con, flushQuery);
            }
            con.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Connection (or query) failed", e);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Please add database JAR", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Other error", e);
        }

    }

    private void runUpdate(Connection con, String updateQuery) throws SQLException {
        logger.warning(updateQuery);
        if (configurationModel.getDatabaseConfig().isUpdatesEnabled()) {
            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(updateQuery);
        } else {
            logger.warning("*NOT* sending update SQL to DB...");
        }
    }

    private void runUpdate(PreparedStatement ps) throws SQLException {
        logger.warning(ps.toString());
        if (configurationModel.getDatabaseConfig().isUpdatesEnabled()) {
            ps.executeUpdate();
        } else {
            logger.warning("*NOT* sending update SQL to DB...");
        }
    }

    private void logStep(String s) {
        logger.info("Step " +(logStep++) + ") "+ s);
    }

    /**
     * Get the next value from the prepared set of fake values.
     * Works also in case there are fewer fake values than real rows. In that case, we are rotating over the fake value array.
     * @param columnMapping
     * @return
     */
    private String getNextValueFor(ColumnMapping columnMapping) {
        Pair<JsonArray,Integer> arrCacheWithLatestIndex= cachedJSONrowsPerFile.get(columnMapping.getLocalJSON());
        String res;
        if (columnMapping.getJsonType()== ColumnMapping.JSONType.STRING) {
            res = arrCacheWithLatestIndex.fst.
                    get(arrCacheWithLatestIndex.snd).
                    asJsonObject().
                    getString(columnMapping.getJsonAttribute());
        } else {
            res= Integer.toString(arrCacheWithLatestIndex.fst.
                    get(arrCacheWithLatestIndex.snd).
                    asJsonObject().
                    getInt(columnMapping.getJsonAttribute()));
        }
        int nextIndex= (arrCacheWithLatestIndex.snd < arrCacheWithLatestIndex.fst.size()-1?
                arrCacheWithLatestIndex.snd+1 : 0);
        cachedJSONrowsPerFile.put(
                columnMapping.getLocalJSON(),
                new Pair<JsonArray,Integer>(arrCacheWithLatestIndex.fst, nextIndex));
        return res;
    }

    /**
     * Download Mockaroo data and cache it to a local file (= speedup between different runs of this program). Also cache the values in-memory (= significant speedup within one execution of this program)
     * @param columnMappings
     * @throws IOException
     */
    private void cacheFiles(ColumnMapping[] columnMappings) throws IOException {
        for (ColumnMapping columnMapping : columnMappings) {
            // ensure file exists
            File target = FileUtils.getFile(columnMapping.getLocalJSON());
            if (target.exists()) {
                logger.warning("target file already exists");
            } else {
                logger.fine("target file will be downloaded and cached");
                try {
                    FileUtils.copyURLToFile(new URL(columnMapping.getMockarooURL()), target);
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Malformed URL: " + columnMapping.getMockarooURL(), e);
                    throw e;
                }
            }
            if (!cachedJSONrowsPerFile.containsKey(cachedJSONrowsPerFile)) { // note: this if can even occur when target exists (since the file could exist from a previous run)
                // use content, cache to map
                javax.json.JsonReader jsonReader = javax.json.Json.createReader(
                        new FileInputStream(target)
                );
                javax.json.JsonArray cachedJSONrows = jsonReader.readArray();
                cachedJSONrowsPerFile.put(columnMapping.getLocalJSON(), new Pair(cachedJSONrows,0));
            }
        }

    }
}
