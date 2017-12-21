package com.example.demo.pattern.singleton.eager;

/**
 * Created by jiaozhiguang on 2017/12/15.
 *
 * 好处是编写简单，但是无法做到延迟创建对象
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {

    }
    public Singleton getSingleton() {
        return singleton;
    }
}
