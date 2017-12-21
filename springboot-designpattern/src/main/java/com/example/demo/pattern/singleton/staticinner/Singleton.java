package com.example.demo.pattern.singleton.staticinner;

/**
 * Created by jiaozhiguang on 2017/10/18.
 *
 由于静态内部类SingletonHolder只有在getInstance()方法第一次被调用时，才会被加载，而且构造函数为private，
 因此该种方式实现了懒汉式的单例模式。不仅如此，根据JVM本身机制，静态内部类的加载已经实现了线程安全
 */
public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }
}
