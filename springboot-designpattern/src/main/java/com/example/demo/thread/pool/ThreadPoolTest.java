package com.example.demo.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2017/12/14.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService cached = Executors.newCachedThreadPool();
        cached.submit(() -> System.out.println("cached"));
        cached.shutdown();

        ExecutorService fixed = Executors.newFixedThreadPool(2);
        fixed.submit(() -> System.out.println("fixed"));
        fixed.shutdown();


    }

}
