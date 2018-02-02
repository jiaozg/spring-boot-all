package com.example.demo.jvm;

/**
 * Created by jiaozhiguang on 2017/11/30.
 */
public class Test {

    public static void main(String[] args) {
        Runtime.getRuntime().gc();
        Thread.yield();
        long iBefore =Runtime.getRuntime().freeMemory();

//        Object obj = new Object();
        String str = "a";
        Runtime.getRuntime().gc();
        Thread.yield();
        long iAfter =Runtime.getRuntime().freeMemory();
        System.out.println(iBefore-iAfter);
    }


}
