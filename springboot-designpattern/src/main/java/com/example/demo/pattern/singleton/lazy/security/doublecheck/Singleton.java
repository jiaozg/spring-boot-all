package com.example.demo.pattern.singleton.lazy.security.doublecheck;

/**
 * Created by jiaozhiguang on 2017/12/15.
 *
 * 这种方法可以实现延时加载，
 * 但是有一个致命弱点：线程不安全。如果有两条线程同时调用getSingleton()方法，就有很大可能导致重复创建对象。
 */
public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton(){}

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
