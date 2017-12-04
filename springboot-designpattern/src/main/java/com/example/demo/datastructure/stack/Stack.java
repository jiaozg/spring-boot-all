package com.example.demo.datastructure.stack;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public interface Stack {

    void clear();

    void push(Object o);

    Object pop();

    Object peek();

    boolean isEmpty();

    int size();

}
