package com.example.demo.thread;

/**
 * Created by jiaozhiguang on 2017/10/12.
 */
public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("thread name: "+ Thread.currentThread().getName());
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Thread thread = new HelloThread();
        thread.start();
    }

}
