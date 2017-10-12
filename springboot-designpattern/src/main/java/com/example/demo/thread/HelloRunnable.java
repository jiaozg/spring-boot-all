package com.example.demo.thread;

/**
 * Created by jiaozhiguang on 2017/10/12.
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Thread helloThread = new Thread(new HelloRunnable());
        helloThread.start();
    }
}
