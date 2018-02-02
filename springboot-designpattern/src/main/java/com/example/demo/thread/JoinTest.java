package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jiaozhiguang on 2018/1/15.
 */
public class JoinTest {

    static CountDownLatch latch = new CountDownLatch(1);

    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t1");
        }
    });

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t2");
        }
    });

    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t3");
        }
    });

    static Thread t4 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t4");
        }
    });

    public static void main(String[] args) throws Exception {
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
