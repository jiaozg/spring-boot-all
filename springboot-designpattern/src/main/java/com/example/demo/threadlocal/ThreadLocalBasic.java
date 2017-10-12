package com.example.demo.threadlocal;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * main线程对local变量的设置对child线程不起作用，child线程对local变量的改变也不会影响main线程，
 * 它们访问的虽然是同一个变量local，但每个线程都有自己的独立的值，这就是线程本地变量的含义。
 */
public class ThreadLocalBasic {

    static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread child = new Thread() {
            @Override
            public void run() {
                System.out.println("child thread initial: " + local.get());
                local.set(200);
                System.out.println("child thread final: " + local.get());
            }
        };
        local.set(100);
        child.start();
        child.join();
        System.out.println("main thread final: " + local.get());
    }

}
