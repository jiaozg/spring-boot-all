package com.example.demo.thread.pool.single;

/**
 * Created by jiaozhiguang on 2018/1/23.
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行.......");
    }
}
