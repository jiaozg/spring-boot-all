package com.example.demo.pattern.singleton;

/**
 * Created by jiaozhiguang on 2017/10/29.
 */
public class MyConnection {

    public MyConnection() throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i <10000 ; i++) {

        }
    }

    public void getConn() {
        System.out.println();
    }

}
