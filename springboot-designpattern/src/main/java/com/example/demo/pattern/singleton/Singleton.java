package com.example.demo.pattern.singleton;

/**
 * Created by jiaozhiguang on 2017/10/18.
 */
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }
}
