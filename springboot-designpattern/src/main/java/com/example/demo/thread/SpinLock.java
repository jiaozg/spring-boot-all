package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 是采用让当前线程不停地的在循环体内执行实现的
 */

public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {

        Thread current = Thread.currentThread();

        System.out.println(current);
        System.out.println(sign);

        while (!sign.compareAndSet(null, current)) {

            System.out.println("业务逻辑");

        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
        System.out.println("解锁");
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        spinLock.lock();
    }


}
