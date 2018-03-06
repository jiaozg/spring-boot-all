package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by jiaozhiguang on 2018/2/24.
 */
public class ThreeWayThread {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一种方式
        Thread t1 = new Thread(){

            @Override
            public void run() {
                System.out.println("new Thread 1");//输出:new Thread 1
            }
        };//创建线程

        t1.start();//启动线程
        System.out.println(t1.getName());//输出:Thread-0

        //第二种方式
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("new Thread 2");//输出:new Thread 2
            }
        });

        t2.start();

        System.out.println(Thread.currentThread().getName());//输出:main


        //第三种方式
        FutureTask<String> ft = new FutureTask<String>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("new Thread 3");//输出:new Thread 3
                return "aaaa";
            }
        });

        Thread t3 = new Thread(ft);
        t3.start();
        String result = ft.get();
        System.out.println(result);//输出:aaaa
    }

}
