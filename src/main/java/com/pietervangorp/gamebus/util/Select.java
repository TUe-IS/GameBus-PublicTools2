/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pietervangorp.gamebus.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction; 
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * A simple customized class for the Stream interface so as to facilitate data masking operations on Java Streams
 * @author praghletoos
 */
public class Select<T> implements Stream<T>{

    
    protected  Select(Stream<T> data){ this.data = data;}
    private Stream<T> data;
     
    
     
    public static<T> Select<T> of(Collection<T> data){
        return new Select<>(data.stream());
        
    }
    public <F> EntityMasker<T,F> maskColumn(String field,Class<F> clazz){
        return EntityMasker.of(this.collect(Collectors.toList()), field, clazz);
    }
    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        
        return new Select<>(data.filter(predicate));
    }
     
    public Select<T> where(Predicate<? super T> predicate) {
        
        return new Select<>(data.filter(predicate));
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return  new Select<>( data.map(mapper));
    }
     
    
    public <R> Select<R> project(Function<? super T, ? extends R> mapper) {
        return  new Select<>( data.map(mapper));
    }
    
    
    
     

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return data.mapToInt(mapper);
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return data.mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return data.mapToDouble(mapper);
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return  new Select<>(data.flatMap(mapper));
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return data.flatMapToInt(mapper);
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return data.flatMapToLong(mapper);
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return data.flatMapToDouble(mapper);
    }

    @Override
    public Stream<T> distinct() {
        return  new Select<>(data.distinct());
    }

    @Override
    public Stream<T> sorted() {
        return  new Select<>(data.sorted());
    }

    @Override
    public Stream<T> sorted(Comparator<? super T> comparator) {
        return  new Select<>(data.sorted(comparator));
    }

    @Override
    public Stream<T> peek(Consumer<? super T> action) {
        return  new Select<>(data.peek(action));
    }

    @Override
    public Stream<T> limit(long maxSize) {
        return  new Select<>(data.limit(maxSize));
    }

    @Override
    public Stream<T> skip(long n) {
        return  new Select<>(data.skip(n));
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        data.forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        data.forEachOrdered(action);
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return data.toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return data.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return data.reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return data.reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return data.collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return data.collect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return data.min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return data.max(comparator);
    }

    @Override
    public long count() {
        return data.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return data.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return data.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return data.noneMatch(predicate);
    }

    @Override
    public Optional<T> findFirst() {
        return data.findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return data.findAny();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return data.spliterator();
    }

    @Override
    public boolean isParallel() {
        return data.isParallel();
    }

    @Override
    public Stream<T> sequential() {
        return  new Select<>(data.sequential());
    }

    @Override
    public Stream<T> parallel() {
        return  new Select<>(data.parallel());
    }

    @Override
    public Stream<T> unordered() {
        return  new Select<>(data.unordered());
    }

    @Override
    public Stream<T> onClose(Runnable closeHandler) {
        return  new Select<>(data.onClose(closeHandler));
    }

    @Override
    public void close() {
        data.close();
    }
    
}
