package com.example.demo.thread;

/**
 * Created by jiaozhiguang on 2017/10/12.
 */
public class VisibilityDemo  {

    private static boolean shutdown = false;

    static class HelloThread extends Thread {
        @Override
        public void run() {
            while(!shutdown){
                // do nothing
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }

}
