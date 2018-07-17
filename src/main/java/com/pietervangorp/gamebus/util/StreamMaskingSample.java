/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pietervangorp.gamebus.util;

import com.google.common.base.Strings;
import com.google.gson.Gson; 
import com.pietervangorp.gamebus.util.webentity.Employee; 
import com.pietervangorp.gamebus.util.webentity.FLocation;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List; 
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.bytebuddy.ByteBuddy;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author praghletoos
 */
public class StreamMaskingSample {
    
    public static void main(String[] args){
        // TODO code application logic here
        new StreamMaskingSample().main();
//        new StreamMaskingSample().main2();
        
    }
    private <T> void print(List<T> data){
        data.stream().forEach(System.out::println);;
    }
    
    private String getFieldValue(Object obj,String field){
        try{
            return  PropertyUtils.getSimpleProperty(obj, field).toString();
        }catch(Exception e){e.printStackTrace();}
        return "";
    }
    
    private String obj2str(Object obj){
        
        return Arrays.asList(obj.getClass().getMethods())
                .stream().map(a -> a.getName())
                .filter(a -> a.startsWith("get")).map(a -> Character.toLowerCase(a.charAt(3)) + a.substring(4))
                .map(a -> a +"= " + getFieldValue(obj, a))
                .collect(Collectors.joining(" || "));
    }
    
    //sample 2
    //loading data from future config file
    private void main2(){
        // creating java beans in runtime
        Class<?> employeeType = new ByteBuddy().subclass(Object.class)
                    .name("Employee") 
                    .defineProperty("id", Integer.TYPE)
                    .defineProperty("country", String.class)
                    .defineProperty("birth", String.class)
                    .defineProperty("email", String.class)
                    .defineProperty("branch", String.class)
                    .defineProperty("salary", Float.TYPE)
                    .make()
                    .load(this.getClass().getClassLoader())
                    .getLoaded();
        
        Class<?> locationType = new ByteBuddy().subclass(Object.class)
                    .name("Location") 
                    .defineProperty("id", Integer.TYPE)
                    .defineProperty("country", String.class)
                    .defineProperty("city", String.class)
                    .make()
                    .load(this.getClass().getClassLoader())
                    .getLoaded();
        
        
        List<?> employees = DataAccessHelper.retrieveJson
                                    ("https://my.api.mockaroo.com/employee002.json?key=5480a260", employeeType);
        
        List<?> locations = DataAccessHelper.retrieveJson
                                ("https://my.api.mockaroo.com/location_mock.json?count=100&key=ebf97070", locationType);
        
        //print data before data masking
        employees.stream().map(a->obj2str(a)).forEach(  System.out::println);
        System.out.println(Strings.repeat("-", 100));
        
        //data masking
        
        Select.of(employees)
                .maskColumn("birth", String.class)
                    .recodingDate() 
                .maskColumn("id", Integer.TYPE)
                    .shuffle() 
                .maskColumn("email", String.class)
                    .emailSuppress()
                    .shuffle()
                .maskColumn("salary", Float.TYPE)
                    .topCoding(120010f,9010f,15010f,75010f,45010f)
                    .roundTo(1000f)
                    .distortByGrouping(60000f, "branch", String.class)
                .maskColumn("country", String.class)
                    .randomFillWith(locations, "city");
        
        //print data after data masking
        employees.stream().map(a->obj2str(a)).forEach(  System.out::println);
        
    }
    
    //sample 1
    private void main() {
       
        List<Employee> employees = DataAccessHelper.retrieveJson
                            ("https://my.api.mockaroo.com/employee002.json?key=5480a260", Employee.class);
        List<FLocation> locations = DataAccessHelper.retrieveJson
                        ("https://my.api.mockaroo.com/location_mock.json?count=100&key=ebf97070", FLocation.class);
        
        print(employees);
        System.out.println(Strings.repeat("-", 100));
        
        Select.of(employees).where(e -> e.salary > 50000)
                .maskColumn("birth", String.class)
                    .recodingDate() 
                .maskColumn("id", Integer.TYPE)
                    .shuffle() 
                .maskColumn("email", String.class)
                    .emailSuppress()
                    .shuffle()
                .maskColumn("salary", Float.TYPE)
                    .topCoding(120010f,9010f,15010f,75010f,45010f)
                    .roundTo(1000f)
                    .distortByGrouping(60000f, "branch", String.class)
                .maskColumn("country", String.class)
                    .randomFillWith(locations, "city");
        
                
        print(employees);
        
                     
    }
}
