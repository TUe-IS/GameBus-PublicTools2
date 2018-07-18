/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pietervangorp.gamebus.util;

import com.google.common.base.Strings;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Implementations of data masking algorithms
 * @author praghletoos
 */
public class EntityMasker<T,F>{
    private String fieldName;
    private Class<F> clazz; 
    private List<T> data;

    private EntityMasker (){}
    
    /**
     * In order to perform other stream operations on the original data.
     * @return a customized stream from underlying data
     */
    public Select<T> data(){
        return Select.of(data);
    }
    
    public static <T,F> EntityMasker<T,F> of(List<T> data,String fieldName,Class<F> clazz){
        EntityMasker<T,F> em = new EntityMasker<>();
        em.fieldName = fieldName;
        em.clazz = clazz;
        em.data = data;
        return  em;
    }
    /**
     * Creating a number that can be used for all types of number (e.g. Double,Long, ...)
     * It is suitable when we need to work with java reflection and arithmetic operations.
     * @param n a number representing only one numerical type 
     * @return a number representing all numerical types 
     */
    private Number makeNumber(Number n){
        double d = n.doubleValue();
        
        return new Number() {
            @Override
            public int intValue() {
                return (int) d;
            }

            @Override
            public long longValue() {
                return (long) d;
            }

            @Override
            public float floatValue() {
                return (float) d;
            }

            @Override
            public double doubleValue() {
                return d;
            }
        };
    }
    private Number round(Number cValue,Number rValue){
        final double d = (((int) (cValue.doubleValue() / rValue.doubleValue()) ) * rValue.doubleValue() );
        return makeNumber(d);
    }
    /**
     * In order to transform the field in all rows based on a map function.
     * @param mapper A map function
     * @return the EntityMasker itself for performing further operations
     */
    public  EntityMasker<T,F> bind(Function<? super F, ? super F> mapper) {
         
        Select.of(data).forEach(a -> {
            try {
                Object currentValue = PropertyUtils.getSimpleProperty(a, fieldName);
                PropertyUtils.setSimpleProperty(a, fieldName,  mapper.apply( (F) currentValue  ));
            } catch ( Exception ex) {
                ex.printStackTrace();
            }  
            
        });
        
        return this;
    }
    /**
     * The algorithm for round operation, which is mentioned in the SAP paper.
     * For example: roundTo(1000) on 35400 => 35000
     * @param value  the field value of all rows will be dividable to this value.
     * 
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> roundTo(final F value){
       
        if(!(value instanceof Number)){
            System.out.println("Not Possible: round");
            return this;
        }
        return bind(a -> {
            Number n = round((Number) a, (Number) value);
            return ConvertUtils.lookup(clazz).convert(clazz, n);
        });
    }
    /**
     * The algorithm for top-coding, which is mentioned in the SAP paper.
     * For example, instead of showing the exact amount of salary, we can say that it is higher than one of the elements in the @link thresholds.
     * @param thresholds list of values that can be used for the estimation of the actual value
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> topCoding(F ... thresholds){
        
        if(thresholds.length ==0 || !(thresholds[0] instanceof Number)){
            System.out.println("Not Possible: topCoding");
            return this;
        }
        List<Number> vals = Arrays.asList(thresholds).stream().map(a -> makeNumber((Number)a))
                .map(a -> a.doubleValue()).sorted(Collections.reverseOrder())
                .map(a -> makeNumber(a)).collect(Collectors.toList());
        
        bind(a -> {
            Number n = (Number) a;
            Number chosen = vals.get(vals.size()-1);
            for(Number val : vals){
                if(n.doubleValue() > val.doubleValue()){
                    chosen = val;
                    break;
                }
            }
            return ConvertUtils.lookup(clazz).convert(clazz, chosen);
            
        });
        return this;
    }
    /**
     * The algorithm for bottom-coding, which is mentioned in the SAP paper.
     * For example, instead of showing the exact amount of salary, we can say that it is lower than on of the elements in the @link thresholds.
     * @param thresholds list of values that can be used for the estimation of the actual value
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> bottomCoding(F ... thresholds){
        
        if(thresholds.length ==0 || !(thresholds[0] instanceof Number)){
            System.out.println("Not Possible: bottomCoding");
            return this;
        }
        List<Number> vals = Arrays.asList(thresholds).stream()
                .sorted().map(a -> makeNumber((Number)a)).collect(Collectors.toList());
        vals.stream().map(a -> a.doubleValue()).forEach(System.out::println);
        bind(a -> {
            Number n = (Number) a;
            Number chosen = vals.get(vals.size()-1);
            for(Number val : vals){
                if(n.doubleValue() < val.doubleValue()){
                    chosen = val;
                    break;
                }
            }
            return ConvertUtils.lookup(clazz).convert(clazz, chosen);
            
        });
        return this;
    }
    
    /**
     * The algorithm for suppressing, which is mentioned in the SAP paper.
     * it can be used to de-form the value of a field in all rows.
     * @param regex The regular expression for specifying which parts of field must be suppressed.
     * @param replacedBy that data for substitution
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> suppress( String regex,String replacedBy ){
        if(clazz != String.class){
            System.out.println("Not Possible: suppress");
            return this;
        }
        bind(a -> (F) a.toString().replaceAll(regex, replacedBy));
        return this;
        
    }
    
    
    
    /**
     * The algorithm for recoding, which is mentioned in the SAP paper.
     * Note that, this method must be applied on String and Date data types .
     * It only shows the year instead of the full date.
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> recodingDate( ){ 
        if(clazz == String.class){
            return suppress(".*(\\d{4}).*", "$1");
        }else if(clazz == Date.class){
            bind(a -> {
                Date dt = (Date) a;
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.set(Calendar.MONTH, 1);
                c.set(Calendar.DATE,1);
                return (F) c.getTime();
            });
        }else{
            System.out.println("Not Possible: recodingDate");
            return this;
        }
        return this;
    }
    
    /**
     * A useful algorithm for suppressing email addresses.
     * Sample: ghaemifard@aut,ac,ir => XXXXXXXXXX@aut.ac.ir
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> emailSuppress( ){
        
        if(clazz != String.class){
            System.out.println("Not Possible: emailSuppress");
            return this;
        }
        final String regExp3 = "(^[A-Z0-9._%+-]+)(@[A-Z0-9.-]+\\.[A-Z]{2,6}$)";
        final String replacement = "X";
        Pattern r = Pattern.compile(regExp3, Pattern.CASE_INSENSITIVE);
        
        bind(a -> {
            Matcher m = r.matcher(a.toString());
            if(m.find()){
                return (F) (Strings.repeat(replacement, m.group(1).length()) + m.group(2));
            }else{
                return (F) (Strings.repeat(replacement,a.toString().length()));
            }
            
        });
        
        return this;
    }
    
    private void swap(int index1,int index2){
        
        Object obj1 = data.get(index1);
        Object obj2 = data.get(index2);
        try{
            Object tempValue = PropertyUtils.getSimpleProperty(obj1, fieldName);
            PropertyUtils.setSimpleProperty(obj1, fieldName,PropertyUtils.getSimpleProperty(obj2, fieldName) );
            PropertyUtils.setSimpleProperty(obj2, fieldName, tempValue);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    /**
     * The algorithm for data swapping, which is mentioned in the SAP paper.
     * It is the best way to change foreign key values without violating relational constraints. 
     * @return the EntityMasker itself for performing further operations
     */
    
    public EntityMasker<T,F> shuffle( ){
        final HashSet<Integer> remained = new HashSet<Integer>();
        IntStream.rangeClosed(0, (int) (data.size()-1)).forEach(a -> remained.add(a));
        
        while(remained.size()>2){
            int Index = (int )(Math.random()*(remained.size()-1));
            Object firstValue = remained.toArray()[Index];
            
            remained.remove(firstValue);
            
            Index = (int )(Math.random()*(remained.size()-1));
            Object secondValue = remained.toArray()[Index];
            
            remained.remove(secondValue);
            
            swap((int) firstValue, (int) secondValue); 
            
        }
        // if it is important now we can deal with the two remained objects (or only one)
        
        return this;
    }
    
    private void distort(final F maxNoise, Object[] array){
        final HashSet<Integer> remained = new HashSet<Integer>();
        IntStream.rangeClosed(0, array.length-1).forEach(a -> remained.add(a));
        final int capacity = makeNumber((Number)maxNoise).intValue();
        int distrotion = 0;
        // this is a flaw
        if(remained.size() % 2 == 1){
           remained.remove(remained.toArray()[0]);
        }
        while(!remained.isEmpty()){
            int Index = (int )(Math.random()*(remained.size()-1));
            Object realIndex = remained.toArray()[Index];
            
            remained.remove(realIndex);
            if(distrotion>=0){
                distrotion = (int) ((Math.random()*capacity) + capacity);
            }
            
            Object row = array[(int)realIndex];
            try{
                Object rawValue = PropertyUtils.getSimpleProperty(row, fieldName);
                Number n = makeNumber(((Number)rawValue).doubleValue() + distrotion);
                PropertyUtils.setSimpleProperty(row, fieldName,ConvertUtils.lookup(clazz).convert(clazz, n) );
            }catch(Exception e){
                e.printStackTrace();
            }
            
            distrotion = -1 * distrotion;
            
        }
    }
    /**
     * A simple algorithm for implementing differential privacy, based on the SAP web article. 
     * @param maxNoise generating noise based on this maximum number. It must be a positive number.
     * @return the EntityMasker itself for performing further operations
     */
    public EntityMasker<T,F> distortAll(final F maxNoise ){
        if(!(maxNoise instanceof Number)){
            System.out.println("Not Possible: distortAll");
            return this;
        }
        distort(maxNoise, data.toArray());
        
        return this;
    }
    /**
     * The algorithm for micro-aggregation, which is mentioned in the SAP paper.
     * @param <G> type of the column
     * @param maxNoise generating noise based on this maximum number. It must be a positive number.
     * @param column The column name for performing the groupBy operation
     * @param glazz statically declaring the type of the column
     * @return the EntityMasker itself for performing further operations
     */
    public <G> EntityMasker<T,F> distortByGrouping(F maxNoise, String column,Class<G> glazz ){
        if(!(maxNoise instanceof Number)){
            System.out.println("Not Possible: distortByGrouping");
            return this;
        }
        Map<G, List<T>> partitioned = Select.of(data).collect(Collectors.groupingBy(a -> {
            try{
                return (G) PropertyUtils.getSimpleProperty(a, column);
            }catch(Exception e){e.printStackTrace();}
            return (G) null;
        }));
        
        partitioned.keySet().stream().forEach(a ->{
            distort(maxNoise, partitioned.get(a).toArray());
        });
        
        return this;
    }
    /**
     * The algorithm for data exchanging, suitable for dealing with unreliable sources like Mockaroo.
     * The data from @param column of @param fake_data will be extracted as a substitution for underlying data.
     * If the size of @link fake_data is smaller than that of current data, the replacement process begin from the first index. 
     * @param <M> the type of unreliable source.
     * @param fake_data  rows of data which is usually obtained from Mockaroo API.
     * @param column the column name which is used for extracting data
     * @return the EntityMasker itself for performing further operations
     */
    public <M> EntityMasker<T,F> ringFillWith(List<M> fake_data,String column ){
        final AtomicInteger counter = new AtomicInteger(0);
        
        Select.of(data).project(a ->{
            try{
                return (F) PropertyUtils.getSimpleProperty(a, fieldName);
            }catch(Exception e){e.printStackTrace();}
            return (F) null;
        }).distinct().forEach(a ->{
            try{
                Object fakeObject = fake_data.get(counter.getAndIncrement());
                counter.set(counter.get() % fake_data.size());
                F fakeValue = (F) PropertyUtils.getSimpleProperty(fakeObject, column);
                Select.of(data).where(b -> {
                    F originalValue = null;
                    try{
                        originalValue = (F) PropertyUtils.getSimpleProperty(b, fieldName);
                    }catch(Exception e){e.printStackTrace();}
                    return (originalValue != null && originalValue.equals(a));
                }).forEach(c ->{
                    try{
                        PropertyUtils.setSimpleProperty(c, fieldName, fakeValue);
                    }catch(Exception e){e.printStackTrace();}
                });
                
                
            }catch(Exception e){e.printStackTrace();}
        });
        
        return this;
    }
    /**
     * The algorithm for data exchanging.
     * It is a method to cope with foreign keys, since changing IdRefs may cause violating the relational constraints.
     * To prevent that, the correct data must be obtained from other reliable sources which is declared in @link foreignList.
     * The rows in the foreignList will be chosen randomly.
     * @param <M> type of foreign source
     * @param foreignList list of foreign data
     * @param column the column name which is used for extracting data
     * @return the EntityMasker itself for performing further operations
     */
    public <M> EntityMasker<T,F> randomFillWith( List<M> foreignList,String column){
        
        List<F> foreignValues = Select.of(foreignList).project(a ->{
            try{
                return (F) PropertyUtils.getSimpleProperty(a, column);
            }catch(Exception e){e.printStackTrace();}
            return (F) null;
        }).collect(Collectors.toList());
        
        Select.of(data).sequential().forEach(a ->{
            int indx = (int) ((Math.random()*(foreignValues.size()-1)));
            try{
                PropertyUtils.setSimpleProperty(a, fieldName, foreignValues.get(indx));
                
            }catch(Exception e){e.printStackTrace();}
        });
        
        
        return this;
    }
    
    /**
     * Switching from a column to another one
     * @param <F> Type of the field
     * @param field name of the field
     * @param clazz statically declaring the type of the field
     * @return an instance of EntityMasker for further data masking
     */
    public <F> EntityMasker<T,F> maskColumn(String field,Class<F> clazz){
        return EntityMasker.of(data, field, clazz);
    }
    
   
}
    
    
    
    
     
    
    
