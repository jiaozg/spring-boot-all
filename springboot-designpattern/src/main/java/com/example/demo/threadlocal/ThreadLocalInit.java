package com.example.demo.threadlocal;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * initialValue用于提供初始值，它是一个受保护方法，可以通过匿名内部类的方式提供，当调用get方法时，
 * 如果之前没有设置过，会调用该方法获取初始值，默认实现是返回null。
 * remove删掉当前线程对应的值，如果删掉后，再次调用get，会再调用initialValue获取初始值
 */
public class ThreadLocalInit {

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){

        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public static void main(String[] args) {
        System.out.println(local.get());
        local.set(200);
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
    }

}
