package com.example.demo.datastructure.stack;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class ArrayStack implements Stack {

    private static int DEFAULT_SIZE = 100;
    private int top;
    Object [] array;

    public ArrayStack() {
        this.top = 0;
        array = new Object[DEFAULT_SIZE];
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(Object o) {
        array[top] = o;
        top++;
    }

    @Override
    public Object pop() {
        if (top == 0) {
            throw new IllegalStateException();
        }
        top--;
        Object val = array[top];
        array[top] = null;
        return val;
    }

    @Override
    public Object peek() {
        if (top == 0) {
            throw new IllegalStateException();
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }
}
