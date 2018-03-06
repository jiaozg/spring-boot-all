package com.example.demo.thread.countdowenlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2018/3/6.
 */
public class CountDownLatchTest {

    public static int sum = 0;

    public static CountDownLatch latch = new CountDownLatch(100);

    public static ExecutorService pool = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws InterruptedException {


        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    add();
                }
            });
            latch.countDown();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sum);

    }

    public static void add() {

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum++;
    }


}