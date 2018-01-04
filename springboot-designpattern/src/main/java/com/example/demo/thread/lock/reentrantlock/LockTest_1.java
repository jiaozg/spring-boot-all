package com.example.demo.thread.lock.reentrantlock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockTest_1 {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        final LockTest_1 test = new LockTest_1();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {
        Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }

}