package com.example.demo.datastructure;

import java.util.LinkedList;

/**
 * Created by jiaozhiguang on 2017/10/16.
 */
public class MyQueue<E> {

    private LinkedList<E> list = new LinkedList<>();

    // 入队
    public void enqueue(E e) {
        list.addLast(e);
    }

    // 出队
    public E dequeue() {
        return list.removeFirst();
    }
}
