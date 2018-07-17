/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pietervangorp.gamebus.util;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.pietervangorp.gamebus.util.entity.AccountDemo;
import com.pietervangorp.gamebus.util.entity.LocationDemo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.pietervangorp.gamebus.util.webentity.Employee;
import com.pietervangorp.gamebus.util.webentity.FLocation;

/**
 *
 * @author praghletoos
 */
public class DataMasker {

    /**
     * @param args the command line arguments
     */
    
    private static EntityManagerFactory factory;
    private static final Logger logger = Logger.getLogger(DataMasker.class.getName());
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        factory = Persistence.createEntityManagerFactory("DataMaskerPU");
        new DataMasker().main();
    }
    // an implementation of differential privacy            
    private void distort(List<Employee> employees){
        final HashSet<Integer> remained = new HashSet<Integer>();
        IntStream.rangeClosed(0, employees.size()-1).forEach(a -> remained.add(a));
        final int capacity = 60000;
        int distrotion = 0;
        if(remained.size() % 2 == 1){
           remained.remove(remained.toArray()[0]);
        }
        while(!remained.isEmpty()){
            int Index = (int )(Math.random()*(remained.size()-1));
            Object firstValue = remained.toArray()[Index];
            
            remained.remove(firstValue);
            if(distrotion>=0){
                distrotion = (int) ((Math.random()*capacity) + capacity);
            }
            employees.get((int)firstValue).salary += distrotion;
            
            distrotion = -1 * distrotion;
            
        } 
    } 
    
    private void main() throws MalformedURLException, IOException{
        EntityManager em = factory.createEntityManager();
        
        
        List<LocationDemo> locations = em.createNamedQuery("LocationDemo.findAll", LocationDemo.class).getResultList();
        List<AccountDemo> accounts = em.createNamedQuery("AccountDemo.findAll", AccountDemo.class).getResultList();
        
        logger.info("# of rows in locations: " + locations.size());
        logger.info("# of rows in accounts: " + accounts.size());
         
        
        final FLocation[] fake_data = new Gson().fromJson(new InputStreamReader(
                new URL("https://my.api.mockaroo.com/location_mock.json?count=100&key=ebf97070").
                        openStream()),FLocation[].class);
        
        final Employee[] fake_employees = new Gson().fromJson(new InputStreamReader(
                new URL("https://my.api.mockaroo.com/employee002.json?key=5480a260").
                        openStream()),Employee[].class);
        List<Employee> employees = Arrays.asList(fake_employees);
        
        logger.info("# of rows in employees: " + employees.size());

        //comment this if you want the changes would be applied to the underlying DB 
        em.close();
        
        //and uncomment these
//        em.getTransaction().begin();
        
        
        
        final AtomicInteger counter = new AtomicInteger(0);
        
        //street => Changing the street (location) values based on mockaroo API
        
        logger.info("The street value (before):" + locations.get(0).getLocation());
        locations.stream().map(a -> a.getLocation()).distinct().forEach(b -> {
            final String newValue = fake_data[counter.getAndIncrement()].street;
            counter.set(counter.get() % fake_data.length);
            //we can filter the rows based on any condition. in the first filter we've accepted all the rows.
            locations.stream().filter(a -> true)
                    .filter(a -> a.getLocation().equals(b)).forEach(c ->{
                c.setLocation(newValue);
            });
        });
        counter.set(0);
        logger.info("The street value (after):" + locations.get(0).getLocation());
        logger.info(Strings.repeat("-", 15));
        
        
        //city => Changing the city values based on mockaroo API
        
        logger.info("The city value (before):" + locations.get(0).getCity());
        locations.stream().map(a -> a.getCity()).distinct().forEach(b -> {
            final String newValue = fake_data[counter.getAndIncrement()].city;
            counter.set(counter.get() % fake_data.length);
            //we can filter the rows based on any condition. in the first filter we've accepted all the rows.
            locations.stream().filter(a -> true)
                    .filter(a -> a.getCity().equals(b)).forEach(c ->{
                c.setCity(newValue);
            });
        });
        counter.set(0);
        logger.info("The city value (after):" + locations.get(0).getCity());
        logger.info(Strings.repeat("-", 15));
        
        //country => Changing the country values based on mockaroo API
        
        logger.info("The country value (before):" + locations.get(0).getCountry());
        locations.stream().map(a -> a.getCountry()).distinct().forEach(b -> {
            final String newValue = fake_data[counter.getAndIncrement()].country;
            counter.set(counter.get() % fake_data.length);
            //we can filter the rows based on any condition. in the first filter we've accepted all the rows.
            locations.stream().filter(a -> true)
                    .filter(a -> a.getCountry().equals(b)).forEach(c ->{
                c.setCountry(newValue);
            });
        });
        logger.info("The country value (after):" + locations.get(0).getCountry());
        logger.info(Strings.repeat("-", 15));
        
        
        //Data Swapping (based on the paper) - we want to shuffle the foreign keys or IdRefs
        
        logger.info("The account value (before data swapping):" + locations.get(0).getAccount());
        final HashSet<Integer> remained = new HashSet<Integer>();
        IntStream.rangeClosed(0, locations.size()-1).forEach(a -> remained.add(a));
        
        while(remained.size()>2){
            int Index = (int )(Math.random()*(remained.size()-1));
            Object firstValue = remained.toArray()[Index];
            
            remained.remove(firstValue);
            
            Index = (int )(Math.random()*(remained.size()-1));
            Object secondValue = remained.toArray()[Index];
            
            remained.remove(secondValue);
            
            swapAccount(locations, (int) firstValue, (int) secondValue);
            //swapCity(resultList, (int) firstValue, (int) secondValue);
            
        }
        // if it is important now we can deal with the two remained objects (or only one)
        logger.info("The account value (after data swapping):" + locations.get(0).getAccount());
        logger.info(Strings.repeat("-", 15));
        
        //Data Exchanging. We want to change the foreign kets and the its data come from the foreign table so we can avoid dangling references
        
        logger.info("The account value (before data exchanging):" + locations.get(0).getAccount());
        List<Integer> accounts_ids = accounts.stream().map(a -> a.getId()).collect(Collectors.toList());
        locations.stream().forEach(a ->{
            int index = (int) ((Math.random()*(accounts_ids.size()-1)));
            a.setAccount(accounts_ids.get(index));
        });
        logger.info("The account value (after data exchanging):" + locations.get(0).getAccount());
        logger.info(Strings.repeat("-", 15));
        
        
        //suppressing data - based on regular expressions: we want to replace all the numbers in a street with the char '#'
        
        final String regExpr = "\\d+";
        final String replacedBy = "#";
        locations.get(0).setLocation("St. Mike 23 Blv 12");
        logger.info("The street value (before suppressing data):" + locations.get(0).getLocation());
        // we've filtered the rows where their city len > 3
        locations.stream().filter(a -> a.getLocation().length()>3).forEach(b -> {
            b.setLocation(b.getLocation().replaceAll(regExpr, replacedBy));
        });
        logger.info("The street value (after suppressing data):" + locations.get(0).getLocation());
        logger.info(Strings.repeat("-", 15));
         
        //Recoding (based on the paper) -> generalising the birth date. only the year will be displayed.
        
        logger.info("The birth value (before recoding):" + employees.get(0).birth);
        final String regExpr2 = "(\\d{4}).*";
        employees.stream().filter(z -> {return true;}).forEach(a -> {
            a.birth = a.birth.replaceAll(regExpr2, "$1");
            
        });
        logger.info("The birth value (after recoding):" + employees.get(0).birth);
        logger.info(Strings.repeat("-", 15));
        
        //Top-coding or Bottom-coding (based on the paper)
        
        logger.info("The salary (before top-coding):" + employees.get(0).salary);
        employees.stream().filter(a -> {return true;}).forEach(a -> {
                if(a.salary > 120010){
                    a.salary = 120010;
                }else if(a.salary > 75010){
                    a.salary = 75010;
                }else if(a.salary > 15010){
                    a.salary = 15010;
                }else{
                    a.salary = 5010;
                }
        });
        logger.info("The salary (after top-coding):" + employees.get(0).salary);
        logger.info(Strings.repeat("-", 15));
        
        // Round (based on the paper) - generalising the Salary (Round it to 1000) 
        
        logger.info("The salary (before rounding to 1000):" + employees.get(0).salary);
         employees.stream().filter(a -> {return true;}).forEach(a -> {
                a.salary = ((int)(a.salary / 1000)) * 1000;
        });
        logger.info("The salary (after rounding to 1000):" + employees.get(0).salary);
        logger.info(Strings.repeat("-", 15));
         
        //email suppression using regex
        
        logger.info("The email (before suppression):" + employees.get(0).email);
        final String regExp3 = "(^[A-Z0-9._%+-]+)(@[A-Z0-9.-]+\\.[A-Z]{2,6}$)";
        final String replacement = "X";
        Pattern r = Pattern.compile(regExp3, Pattern.CASE_INSENSITIVE);
        employees.stream().filter(a -> true).forEach(a ->{
            Matcher m = r.matcher(a.email);
            if(m.find()){
                a.email = Strings.repeat(replacement, m.group(1).length()) + m.group(2);
            }
        });
        logger.info("The email (after suppression):" + employees.get(0).email);
        
        //Adding noise (based on the paper) - it is similat to the differential privacy.
        //adding a simple distortion to the salary where the sum of all the noise would be 0 (The SAP article)
        
        logger.info("The salary (before adding noise):" + employees.get(0).salary);
        Optional<Float> sum = employees.stream().map(a -> a.salary).reduce((a,b) -> a+b);
        logger.info("the sum of salaries (before adding noise):" + sum.get());
        
        distort(employees);
        
        logger.info("The salary (after adding noise):" + employees.get(0).salary);
        sum = employees.stream().map(a -> a.salary).reduce((a,b) -> a+b);
        logger.info("the sum of salaries (after adding noise):" + sum.get());
        
        logger.info(Strings.repeat("-", 15));
        
        
        //Micro-aggregation (based on the paper)
       
        Map<String, List<Employee>> partitioned = employees.stream().collect(Collectors.groupingBy(a -> a.branch));
        partitioned.keySet().stream().forEach(k->{
            logger.info("The branch :" + k);
            logger.info(Strings.repeat("*", 15));
            logger.info( "Values (before micro-aggregating):" +  partitioned.get(k).stream().map(a -> a.salary +"").collect(Collectors.joining(" | ")));
            logger.info("the sum of values (before micro-aggregating):" + partitioned.get(k).stream().map(a -> a.salary).reduce((a,b)-> a+b).get());
            distort(partitioned.get(k));
            logger.info( "Values (after micro-aggregating):" +  partitioned.get(k).stream().map(a -> a.salary +"").collect(Collectors.joining(" | ")));
            logger.info("the sum of values (after micro-aggregating):" + partitioned.get(k).stream().map(a -> a.salary).reduce((a,b)-> a+b).get());
            
            
        });
        
        
        //saving the changes to the database
//        em.getTransaction().commit();
//        em.close();
        
        
    }
    
     
    
    private void swapCity(List<LocationDemo> data,int index1,int index2){
        String tempCity = data.get(index1).getCity();
        data.get(index1).setCity(data.get(index2).getCity());
        data.get(index2).setCity(tempCity);
    }
    private void swapAccount(List<LocationDemo> data,int index1,int index2){
        Integer temp = data.get(index1).getAccount();
        data.get(index1).setAccount(data.get(index2).getAccount());
        data.get(index2).setAccount(temp);
    }
    
}
