package com.example.demo;

/**
 * Created by jiaozhiguang on 2017/11/8.
 */
public class Test {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("old way");
            }
        }).start();

        new Thread(()->System.out.println("new way")).start();


    }
}
