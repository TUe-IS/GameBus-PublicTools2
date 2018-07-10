# GameBus-PublicTools2
A set of public tools spinning out of GameBus development. Initially just a simple data masker.

The simple data masker relies on Mockaroo. Please create your own account on Mockaroo and please adjust the example scripts to use your own Mockaroo URLs.

Example on the use of Mockaroo etc. can be found in the demo/HOWTO folder.  You also find MySQL initialisation files in the subfolder 'init'.

The following transcript demostrates a succesful run of the masker tool:

As prerequisites, please install:
 * gradle
 * mysql

To get started, please execute in a terminal, from the main project folder:
```bash
gradle wrapper
```

Next, please run the project as demonstrated in the below transcripts. You can make your own masker projects in the src/resources folder.

```bash
MacBook-Pro-PVG:GameBus-PublicTools2 pvgorp$ gradle demoRun

> Task :compileJava 
warning: [options] bootstrap class path not set in conjunction with -source 1.7
Note: /Users/pvgorp/git/GameBus-PublicTools2/src/main/java/com/pietervangorp/gamebus/util/SimpleDatabaseMasker.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

> Task :demoRun 
Jul 10, 2018 8:04:17 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker main
INFO: args[0]: accounts_locations/ConfigurationModel.json
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker cacheFiles
WARNING: target file already exists
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker cacheFiles
WARNING: target file already exists
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker logStep
INFO: Step 1) Connecting to DB...
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker logStep
INFO: Step 2) Loading data of table Location_Demo for handling property street...
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker anonymize
INFO: select distinct `street` from `Location_Demo`
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7276c8cd: update `Location_Demo` set `street` = '01 Forster Circle' where `street`= '716 Lighthouse Bay Crossing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@544a2ea6: update `Location_Demo` set `street` = '9 Pond Court' where `street`= '05596 Dahle Junction'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2e3fc542: update `Location_Demo` set `street` = '0 Coolidge Street' where `street`= '1 Green Street'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@150c158: update `Location_Demo` set `street` = '76765 Northview Junction' where `street`= '4 Texas Place'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4524411f: update `Location_Demo` set `street` = '7 Scoville Point' where `street`= '51 Del Mar Road'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@401e7803: update `Location_Demo` set `street` = '2 Grasskamp Lane' where `street`= '77 Hagan Avenue'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@10dba097: update `Location_Demo` set `street` = '6893 Superior Trail' where `street`= '531 Blackbird Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1786f9d5: update `Location_Demo` set `street` = '3015 Barby Place' where `street`= '690 Vermont Crossing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@704d6e83: update `Location_Demo` set `street` = '09 Charing Cross Pass' where `street`= '0 Sheridan Terrace'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@43a0cee9: update `Location_Demo` set `street` = '18 Westport Junction' where `street`= '814 Susan Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@eb21112: update `Location_Demo` set `street` = '074 Sundown Road' where `street`= '08 Corben Court'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2eda0940: update `Location_Demo` set `street` = '703 Scott Pass' where `street`= '863 Grayhawk Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3578436e: update `Location_Demo` set `street` = '6 Randy Way' where `street`= '9667 Lake View Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6eceb130: update `Location_Demo` set `street` = '14773 Schurz Pass' where `street`= '001 Hovde Junction'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@10a035a0: update `Location_Demo` set `street` = '361 Pawling Park' where `street`= '222 Cascade Court'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5c072e3f: update `Location_Demo` set `street` = '2191 Delaware Court' where `street`= '55161 Talisman Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4d1b0d2a: update `Location_Demo` set `street` = '10 Talmadge Drive' where `street`= '476 Gerald Junction'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@954b04f: update `Location_Demo` set `street` = '32744 Loomis Street' where `street`= '874 Pond Road'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@149494d8: update `Location_Demo` set `street` = '26990 Westridge Parkway' where `street`= '2 Merry Junction'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@710726a3: update `Location_Demo` set `street` = '7627 Coolidge Way' where `street`= '482 Elgar Junction'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@646007f4: update `Location_Demo` set `street` = '5465 2nd Plaza' where `street`= '57 Vermont Terrace'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@481a15ff: update `Location_Demo` set `street` = '7372 Carpenter Parkway' where `street`= '5 Valley Edge Trail'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@78186a70: update `Location_Demo` set `street` = '8 Eagle Crest Court' where `street`= '3899 Merchant Parkway'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@306279ee: update `Location_Demo` set `street` = '26 Prairie Rose Crossing' where `street`= '7348 Dahle Street'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@545997b1: update `Location_Demo` set `street` = '6309 Del Sol Point' where `street`= '7 Old Gate Court'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4cf4d528: update `Location_Demo` set `street` = '76186 Merry Terrace' where `street`= '1 Scoville Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@77846d2c: update `Location_Demo` set `street` = '38 Crest Line Point' where `street`= '81 Mendota Trail'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@548ad73b: update `Location_Demo` set `street` = '1653 Coolidge Parkway' where `street`= '947 Bartelt Park'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4c762604: update `Location_Demo` set `street` = '91681 Kenwood Avenue' where `street`= '17 Blaine Terrace'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2641e737: update `Location_Demo` set `street` = '54 Fallview Parkway' where `street`= '39 Fremont Way'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@727803de: update `Location_Demo` set `street` = '5112 Hoard Center' where `street`= '2956 Birchwood Drive'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@704921a5: update `Location_Demo` set `street` = '0200 Pearson Lane' where `street`= '12 Tony Trail'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@df27fae: update `Location_Demo` set `street` = '8 Lien Junction' where `street`= '24 Logan Circle'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@24a35978: update `Location_Demo` set `street` = '05210 Golf Course Crossing' where `street`= '99 Lillian Place'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@16f7c8c1: update `Location_Demo` set `street` = '00 Hoepker Plaza' where `street`= '3477 Browning Drive'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2f0a87b3: update `Location_Demo` set `street` = '5 Montana Street' where `street`= '6 Magdeline Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@319b92f3: update `Location_Demo` set `street` = '19 Burrows Place' where `street`= '281 Everett Way'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@fcd6521: update `Location_Demo` set `street` = '49215 Truax Junction' where `street`= '1 Dennis Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@27d415d9: update `Location_Demo` set `street` = '90 Blaine Trail' where `street`= '45789 Burrows Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5c18298f: update `Location_Demo` set `street` = '4187 Hauk Trail' where `street`= '51 Jenna Way'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@31f924f5: update `Location_Demo` set `street` = '2943 Pleasure Plaza' where `street`= '3367 Warner Lane'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5579bb86: update `Location_Demo` set `street` = '70990 Maryland Court' where `street`= '3 Monica Drive'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5204062d: update `Location_Demo` set `street` = '9329 Ryan Place' where `street`= '71760 Schlimgen Crossing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4fcd19b3: update `Location_Demo` set `street` = '6149 Anderson Point' where `street`= '8 Bluejay Street'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@376b4233: update `Location_Demo` set `street` = '7 Goodland Lane' where `street`= '26 North Road'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2fd66ad3: update `Location_Demo` set `street` = '16 Butternut Circle' where `street`= '6 Algoma Park'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5d11346a: update `Location_Demo` set `street` = '0 Fair Oaks Court' where `street`= '0782 Moland Way'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7a36aefa: update `Location_Demo` set `street` = '4268 Farwell Avenue' where `street`= '3 7th Way'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@17211155: update `Location_Demo` set `street` = '7 Eastwood Lane' where `street`= '043 Longview Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@b3d7190: update `Location_Demo` set `street` = '04 Walton Avenue' where `street`= '72 Messerschmidt Road'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5fdba6f9: update `Location_Demo` set `street` = '95808 Vahlen Plaza' where `street`= '999 Crest Line Center'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@10d59286: update `Location_Demo` set `street` = '46850 Columbus Trail' where `street`= '6 Gateway Park'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@fe18270: update `Location_Demo` set `street` = '18 Bunker Hill Street' where `street`= '703 Sachtjen Way'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6fb0d3ed: update `Location_Demo` set `street` = '2404 Carberry Point' where `street`= '3942 Nancy Crossing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6dde5c8c: update `Location_Demo` set `street` = '47187 3rd Point' where `street`= '16 Rusk Hill'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5123a213: update `Location_Demo` set `street` = '1 Mifflin Road' where `street`= '368 Pleasure Terrace'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@52525845: update `Location_Demo` set `street` = '9245 Lien Place' where `street`= '3 Lillian Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3b94d659: update `Location_Demo` set `street` = '6492 Autumn Leaf Parkway' where `street`= '09675 Nelson Avenue'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@24b1d79b: update `Location_Demo` set `street` = '42992 Utah Place' where `street`= '25644 Fisk Circle'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@68ceda24: update `Location_Demo` set `street` = '32 Toban Crossing' where `street`= '5597 Grayhawk Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@281e3708: update `Location_Demo` set `street` = '673 Lighthouse Bay Drive' where `street`= '66317 Comanche Street'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@35a50a4c: update `Location_Demo` set `street` = '1 Kropf Drive' where `street`= '5 Ohio Drive'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1f021e6c: update `Location_Demo` set `street` = '35295 Homewood Alley' where `street`= '2 Northview Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@103f852: update `Location_Demo` set `street` = '117 Schlimgen Park' where `street`= '59 High Crossing Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@587c290d: update `Location_Demo` set `street` = '05481 Hermina Drive' where `street`= '63 Coolidge Park'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4516af24: update `Location_Demo` set `street` = '95 Lighthouse Bay Parkway' where `street`= '6 Lerdahl Circle'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4ae82894: update `Location_Demo` set `street` = '68679 Evergreen Junction' where `street`= '7084 Monica Crossing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@543788f3: update `Location_Demo` set `street` = '92163 Fulton Park' where `street`= '21100 New Castle Crossing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6d3af739: update `Location_Demo` set `street` = '6627 Union Place' where `street`= '86239 Bunker Hill Road'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1da51a35: update `Location_Demo` set `street` = '09 Dennis Hill' where `street`= '88 Spenser Trail'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@16022d9d: update `Location_Demo` set `street` = '4 Pennsylvania Crossing' where `street`= '82522 Milwaukee Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7e9a5fbe: update `Location_Demo` set `street` = '33931 Tennyson Court' where `street`= '5007 Northland Junction'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@44a3ec6b: update `Location_Demo` set `street` = '5374 Jenna Trail' where `street`= '4536 East Place'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@71623278: update `Location_Demo` set `street` = '95 Grim Street' where `street`= '57321 Artisan Lane'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@768b970c: update `Location_Demo` set `street` = '1 Delladonna Trail' where `street`= '09863 Porter Trail'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5a4041cc: update `Location_Demo` set `street` = '38 Dayton Terrace' where `street`= '574 Pleasure Hill'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@15b3e5b: update `Location_Demo` set `street` = '5648 Warrior Road' where `street`= '0 Nova Road'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@61ca2dfa: update `Location_Demo` set `street` = '19 Schiller Place' where `street`= '57 Starling Parkway'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4b53f538: update `Location_Demo` set `street` = '7 Bluestem Place' where `street`= '8410 Basil Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@134593bf: update `Location_Demo` set `street` = '950 Coolidge Junction' where `street`= '76 Corry Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4bb4de6a: update `Location_Demo` set `street` = '2 Kenwood Lane' where `street`= '0017 Novick Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7ba18f1b: update `Location_Demo` set `street` = '0476 Sugar Terrace' where `street`= '5235 Blue Bill Park Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2f8f5f62: update `Location_Demo` set `street` = '037 Sheridan Alley' where `street`= '51 High Crossing Plaza'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1068e947: update `Location_Demo` set `street` = '5 Orin Junction' where `street`= '8665 Carpenter Trail'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7dc222ae: update `Location_Demo` set `street` = '14737 Melvin Court' where `street`= '643 Jackson Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@aecb35a: update `Location_Demo` set `street` = '2 Bonner Trail' where `street`= '91 Leroy Street'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5fcd892a: update `Location_Demo` set `street` = '0246 Dayton Plaza' where `street`= '04277 Schmedeman Alley'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@8b87145: update `Location_Demo` set `street` = '9 Dakota Place' where `street`= '958 Homewood Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6483f5ae: update `Location_Demo` set `street` = '12 Scofield Avenue' where `street`= '7061 Longview Avenue'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@b9afc07: update `Location_Demo` set `street` = '22604 Londonderry Hill' where `street`= '6 Moose Lane'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@382db087: update `Location_Demo` set `street` = '3 Goodland Avenue' where `street`= '6 Nancy Pass'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@73d4cc9e: update `Location_Demo` set `street` = '906 Village Green Point' where `street`= '48645 Eastwood Street'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@80169cf: update `Location_Demo` set `street` = '7223 Kennedy Plaza' where `street`= '4 Crescent Oaks Center'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5427c60c: update `Location_Demo` set `street` = '71 School Drive' where `street`= '2254 Esch Avenue'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@15bfd87: update `Location_Demo` set `street` = '0 Fremont Drive' where `street`= '16 Russell Avenue'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@543e710e: update `Location_Demo` set `street` = '328 Messerschmidt Road' where `street`= '35 Sachtjen Alley'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@57f23557: update `Location_Demo` set `street` = '172 Village Green Parkway' where `street`= '1782 Morning Avenue'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3d0f8e03: update `Location_Demo` set `street` = '6 Nova Road' where `street`= '706 Lillian Hill'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6366ebe0: update `Location_Demo` set `street` = '178 Claremont Plaza' where `street`= '35 Garrison Point'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@44f75083: update `Location_Demo` set `street` = '03423 Victoria Terrace' where `street`= '1574 Londonderry Drive'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker logStep
INFO: Step 3) Loading data of table Location_Demo for handling property city...
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker anonymize
INFO: select distinct `city` from `Location_Demo`
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@43d7741f: update `Location_Demo` set `city` = 'Clermont-Ferrand' where `city`= 'Mizhuang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@17baae6e: update `Location_Demo` set `city` = 'Dabao' where `city`= 'La Purisima'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@69379752: update `Location_Demo` set `city` = 'Béoumi' where `city`= 'Koch\'ang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@27fe3806: update `Location_Demo` set `city` = 'Usagara' where `city`= 'Phan Thong'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5f71c76a: update `Location_Demo` set `city` = 'Guanting' where `city`= 'Paderne'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1d7acb34: update `Location_Demo` set `city` = 'Český Těšín' where `city`= 'Ndib?ne Dahra'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@48a242ce: update `Location_Demo` set `city` = 'Ivry-sur-Seine' where `city`= 'Ciranca'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1e4a7dd4: update `Location_Demo` set `city` = 'Esteio' where `city`= 'Mytishchi'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4f51b3e0: update `Location_Demo` set `city` = 'Yiliu' where `city`= 'Beloostrov'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4b9e255: update `Location_Demo` set `city` = 'Ngedhubasa' where `city`= 'Ritchie'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5e57643e: update `Location_Demo` set `city` = 'Resapombo' where `city`= 'Aguazul'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@133e16fd: update `Location_Demo` set `city` = 'Solnechnyy' where `city`= 'Ialibu'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@51b279c9: update `Location_Demo` set `city` = 'Bol’shoye Skuratovo' where `city`= 'Tantou'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1ad282e0: update `Location_Demo` set `city` = 'Không' where `city`= 'Waiklibang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7f416310: update `Location_Demo` set `city` = 'Xiguantun Muguzu Manzuxiang' where `city`= 'Budapest'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1cab0bfb: update `Location_Demo` set `city` = 'Loyew' where `city`= 'Mörrum'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5e955596: update `Location_Demo` set `city` = 'Liqiao' where `city`= 'Niafunké'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@50de0926: update `Location_Demo` set `city` = 'Quán H?nh' where `city`= 'Weekaka'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2473b9ce: update `Location_Demo` set `city` = 'White City' where `city`= 'Heshi'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@60438a68: update `Location_Demo` set `city` = 'Baculin' where `city`= 'Changy?n'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@140e5a13: update `Location_Demo` set `city` = 'Kruševac' where `city`= 'Dolgoprudnyy'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3439f68d: update `Location_Demo` set `city` = 'Kembang' where `city`= 'Ugljevik'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@dbd940d: update `Location_Demo` set `city` = 'Freiburg im Breisgau' where `city`= 'Tyre'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@71d15f18: update `Location_Demo` set `city` = 'Kotlovka' where `city`= 'Huoche Xizhan'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@17695df3: update `Location_Demo` set `city` = 'Si Khoraphum' where `city`= 'Ambato Boeny'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6c9f5c0d: update `Location_Demo` set `city` = 'Bantacan' where `city`= 'Novodvinsk'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@de3a06f: update `Location_Demo` set `city` = 'Bolboc' where `city`= 'Huancabamba'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@76b10754: update `Location_Demo` set `city` = 'Eskilstuna' where `city`= 'Koubia'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2bea5ab4: update `Location_Demo` set `city` = 'Varkaus' where `city`= 'Bratislava'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3d8314f0: update `Location_Demo` set `city` = 'Tarata' where `city`= 'Luyang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2df32bf7: update `Location_Demo` set `city` = 'San Bernardino' where `city`= 'Lacroix-Saint-Ouen'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@530612ba: update `Location_Demo` set `city` = 'Musanze' where `city`= 'Dongzaogang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2a40cd94: update `Location_Demo` set `city` = 'Wenjiao' where `city`= 'Shangxing'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@f4168b8: update `Location_Demo` set `city` = 'Bergen' where `city`= 'Bantarjati'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3bd94634: update `Location_Demo` set `city` = 'Cizhu' where `city`= 'Pocrí'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@58a90037: update `Location_Demo` set `city` = 'Postojna' where `city`= 'Geshan'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@74294adb: update `Location_Demo` set `city` = 'Valle de La Pascua' where `city`= 'Oripää'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@70a9f84e: update `Location_Demo` set `city` = 'Mabunga' where `city`= 'Shangfang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@130f889: update `Location_Demo` set `city` = 'San Esteban' where `city`= 'Tegalbuleud'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1188e820: update `Location_Demo` set `city` = 'Frutillar' where `city`= 'Lampa'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2f490758: update `Location_Demo` set `city` = 'Milán' where `city`= 'Calabaca'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@101df177: update `Location_Demo` set `city` = 'Mamara' where `city`= '?abā? as Sālim'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@166fa74d: update `Location_Demo` set `city` = 'Pokój' where `city`= 'Novalja'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@40f08448: update `Location_Demo` set `city` = 'Ścinawa' where `city`= 'Khawr Fakkān'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@276438c9: update `Location_Demo` set `city` = 'Loma Bonita' where `city`= 'Washington'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@588df31b: update `Location_Demo` set `city` = 'Liuzhi' where `city`= 'Río Alejandro'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@33b37288: update `Location_Demo` set `city` = 'Stenungsund' where `city`= 'Paris 03'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@77a57272: update `Location_Demo` set `city` = 'Maharagama' where `city`= 'Pasar Kidul'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7181ae3f: update `Location_Demo` set `city` = 'Cipadung Timur' where `city`= 'Si Narong'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@46238e3f: update `Location_Demo` set `city` = 'Khairpur Nathan Shāh' where `city`= 'Gaotan'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6e2c9341: update `Location_Demo` set `city` = 'Évlalo' where `city`= 'Mbumi'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@32464a14: update `Location_Demo` set `city` = 'Tambobamba' where `city`= 'Shentang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4e4aea35: update `Location_Demo` set `city` = 'Jinshan' where `city`= 'Tengrela'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1442d7b5: update `Location_Demo` set `city` = 'Tongzhong' where `city`= 'Filipstad'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1efee8e7: update `Location_Demo` set `city` = 'Carcassonne' where `city`= 'Eha Amufu'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1ee807c6: update `Location_Demo` set `city` = 'Wasagu' where `city`= 'San Bernardino'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@76a4d6c: update `Location_Demo` set `city` = 'Nai Harn' where `city`= 'Le Teil'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@517cd4b: update `Location_Demo` set `city` = 'Turmi' where `city`= 'Xiangshun'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6cc7b4de: update `Location_Demo` set `city` = 'Loja' where `city`= 'Strawberry Hills'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@32cf48b7: update `Location_Demo` set `city` = 'Uryupinsk' where `city`= 'Dongqu'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@679b62af: update `Location_Demo` set `city` = 'San Nicolas' where `city`= 'Kebonagung'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5cdd8682: update `Location_Demo` set `city` = 'La Esperanza' where `city`= 'Bordeaux'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@d6da883: update `Location_Demo` set `city` = 'Goiatuba' where `city`= 'Jokkmokk'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@45afc369: update `Location_Demo` set `city` = 'Kamień Pomorski' where `city`= 'Ape'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@799d4f69: update `Location_Demo` set `city` = 'Rancabungur' where `city`= 'Fareydūnshahr'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@49c43f4e: update `Location_Demo` set `city` = 'Passal' where `city`= 'Frederiksberg'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@290dbf45: update `Location_Demo` set `city` = 'Kalepasan' where `city`= 'Ishqoshim'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@12028586: update `Location_Demo` set `city` = 'Roches Noire' where `city`= 'Lodan Wetan'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@17776a8: update `Location_Demo` set `city` = 'Morteros' where `city`= 'Huamali'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@69a10787: update `Location_Demo` set `city` = 'Jiujie' where `city`= 'Pekan'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2d127a61: update `Location_Demo` set `city` = 'El Paso' where `city`= 'Lindavista'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@2bbaf4f0: update `Location_Demo` set `city` = 'Dresden' where `city`= 'Frei'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@11c20519: update `Location_Demo` set `city` = 'Atlanta' where `city`= 'Zhongcheng'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@70beb599: update `Location_Demo` set `city` = 'Bojongnangka' where `city`= 'Kampong Chhnang'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4e41089d: update `Location_Demo` set `city` = 'Tegalbuleud' where `city`= 'Gandorhun'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@32a068d1: update `Location_Demo` set `city` = 'Lipnica' where `city`= 'Tucupita'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@33cb5951: update `Location_Demo` set `city` = 'Pop' where `city`= 'Kotabumi'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@365c30cc: update `Location_Demo` set `city` = 'Santol' where `city`= '????? ???????'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@701fc37a: update `Location_Demo` set `city` = 'Malinovskiy' where `city`= 'Väster?s'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4148db48: update `Location_Demo` set `city` = 'Oguma' where `city`= 'T?n Vi?t'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@282003e1: update `Location_Demo` set `city` = 'Lopatyn' where `city`= 'Su?ayl Shibām'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@7fad8c79: update `Location_Demo` set `city` = 'Zelenograd' where `city`= 'Nā?īyat Saddat al Hindīyah'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@71a794e5: update `Location_Demo` set `city` = 'Fedorovka' where `city`= 'Me?a'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@76329302: update `Location_Demo` set `city` = 'Poste du Lac' where `city`= 'C?u Gi?y'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5e25a92e: update `Location_Demo` set `city` = 'Balading' where `city`= 'Li?n Chi?u'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4df828d7: update `Location_Demo` set `city` = 'Masuda' where `city`= 'G?axaq'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@b59d31: update `Location_Demo` set `city` = 'Jadho' where `city`= 'Quint?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@62fdb4a6: update `Location_Demo` set `city` = 'Montpellier' where `city`= 'B?c K?n'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@11e21d0e: update `Location_Demo` set `city` = 'Xia Zanggor' where `city`= 'El Pe?ol'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1dd02175: update `Location_Demo` set `city` = 'Araripina' where `city`= 'Chennevi?res-sur-Marne'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@31206beb: update `Location_Demo` set `city` = 'Cidikit Girang' where `city`= 'Bor?s'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3e77a1ed: update `Location_Demo` set `city` = 'Katori-shi' where `city`= 'Cangu?u'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3ffcd140: update `Location_Demo` set `city` = 'Lüderitz' where `city`= 'K?benhavn'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@23bb8443: update `Location_Demo` set `city` = 'Pau' where `city`= 'K?rdzhali'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1176dcec: update `Location_Demo` set `city` = 'Stamford' where `city`= 'Kushch?vskaya'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@120d6fe6: update `Location_Demo` set `city` = 'Vyatskiye Polyany' where `city`= 'Vicu?a'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@4ba2ca36: update `Location_Demo` set `city` = 'Yanqul' where `city`= 'Ber?za'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3444d69d: update `Location_Demo` set `city` = 'Manorhamilton' where `city`= 'Mata de S?o Jo?o'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1372ed45: update `Location_Demo` set `city` = 'Bantu' where `city`= 'Ch?teaudun'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6a79c292: update `Location_Demo` set `city` = 'Songbai' where `city`= 'N?mes'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@37574691: update `Location_Demo` set `city` = 'Clermont-Ferrand' where `city`= 'T?y H?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@25359ed8: update `Location_Demo` set `city` = 'Dabao' where `city`= 'Ipau?u'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@21a947fe: update `Location_Demo` set `city` = 'Béoumi' where `city`= 'Dayrū?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@5606c0b: update `Location_Demo` set `city` = 'Usagara' where `city`= 'Mat?o'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@80ec1f8: update `Location_Demo` set `city` = 'Guanting' where `city`= 'Shupenz?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1445d7f: update `Location_Demo` set `city` = 'Český Těšín' where `city`= 'Markaz-e ?ukūmat-e Darwēshān'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6a396c1e: update `Location_Demo` set `city` = 'Ivry-sur-Seine' where `city`= 'Torre do Pinh?o'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6c3f5566: update `Location_Demo` set `city` = 'Esteio' where `city`= 'S?o Jo?o dos Inhamuns'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@12405818: update `Location_Demo` set `city` = 'Yiliu' where `city`= 'Al Ma?lūb'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@314c508a: update `Location_Demo` set `city` = 'Ngedhubasa' where `city`= 'S?o Sebasti?o'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@10b48321: update `Location_Demo` set `city` = 'Resapombo' where `city`= 'Imām ?ā?ib'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6b67034: update `Location_Demo` set `city` = 'Solnechnyy' where `city`= 'Lule?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@16267862: update `Location_Demo` set `city` = 'Bol’shoye Skuratovo' where `city`= 'Saint-Égr?ve'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@453da22c: update `Location_Demo` set `city` = 'Không' where `city`= 'Est?ncia'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@71248c21: update `Location_Demo` set `city` = 'Xiguantun Muguzu Manzuxiang' where `city`= 'Th? Tr?n M??ng Kh?n'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@442675e1: update `Location_Demo` set `city` = 'Loyew' where `city`= '?amrun'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6166e06f: update `Location_Demo` set `city` = 'Liqiao' where `city`= 'Sollefte?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@49e202ad: update `Location_Demo` set `city` = 'Quán H?nh' where `city`= 'Bubullim?'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@1c72da34: update `Location_Demo` set `city` = 'White City' where `city`= 'Pokrovskoye-Streshn?vo'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6b0c2d26: update `Location_Demo` set `city` = 'Baculin' where `city`= 'Bak?xanov'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@3d3fcdb0: update `Location_Demo` set `city` = 'Kruševac' where `city`= 'Th? Tr?n Tr?ng Khánh'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@641147d0: update `Location_Demo` set `city` = 'Kembang' where `city`= 'Q?rm?z? Samux'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker logStep
INFO: Step 4) Loading data of table Location_Demo for handling property country...
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker anonymize
INFO: select distinct `country` from `Location_Demo`
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@64d7f7e0: update `Location_Demo` set `country` = 'Germany' where `country`= 'Lebanon'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@27c6e487: update `Location_Demo` set `country` = 'Russia' where `country`= 'China'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@49070868: update `Location_Demo` set `country` = 'Thailand' where `country`= 'Madagascar'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@6385cb26: update `Location_Demo` set `country` = 'Philippines' where `country`= 'Russia'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@38364841: update `Location_Demo` set `country` = 'Philippines' where `country`= 'Peru'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@28c4711c: update `Location_Demo` set `country` = 'Sweden' where `country`= 'Guinea'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: com.mysql.jdbc.JDBC4PreparedStatement@59717824: update `Location_Demo` set `country` = 'Finland' where `country`= 'Slovakia'
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker logStep
INFO: Step 5) Flushing data of table sometable1...
Jul 10, 2018 8:04:19 PM com.pietervangorp.gamebus.util.SimpleDatabaseMasker runUpdate
WARNING: truncate `sometable1`


Deprecated Gradle features were used in this build, making it incompatible with Gradle 5.0.
See https://docs.gradle.org/4.6/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 5s
3 actionable tasks: 3 executed
```
