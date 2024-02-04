package ru.mycloud.cloud.mapper;

public interface Merger<T,S> {


    T merge (T target, S source);

}
