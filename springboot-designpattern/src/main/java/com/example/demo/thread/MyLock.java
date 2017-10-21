package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiaozhiguang on 2017/10/16.
 */
public class MyLock {

    private AtomicInteger status = new AtomicInteger(0);

    public void lock() {
        while (!status.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    public void unlock() {
        status.compareAndSet(1, 0);
    }

}
