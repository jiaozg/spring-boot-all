package com.example.demo.thread.racecondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiaozhiguang on 2017/10/12.
 *
 */
public class CounterThread extends Thread {

    private static int counter = 0;
    private static int countersynchronized = 0;
    private static Counter coun = new Counter();

    private final Lock lock = new ReentrantLock();

    public static synchronized void incresynchronized() {
        countersynchronized++;
    }


    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random()*100));
        } catch (InterruptedException e) {
        }
        counter ++;
        incresynchronized();
        coun.incr();
    }


    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for(int i=0; i<num; i++){
            threads[i] = new CounterThread();
            threads[i].start();
        }

        for(int i=0; i<num; i++){
            threads[i].join();
        }

        System.out.println(counter);
        System.out.println(countersynchronized);
        System.out.println(coun.getCount());
    }

}
