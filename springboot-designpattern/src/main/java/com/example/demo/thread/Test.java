package com.example.demo.thread;

/**
 * Created by jiaozhiguang on 2017/12/14.
 */
public class Test {

    public static void main(String[] args) {

        new Thread(new HelloThread()).start();
//        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.start();


    }

    static class HelloThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }




}
