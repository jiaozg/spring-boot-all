package com.example.demo.thread.lock.reentrantlock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 也许有朋友会问，怎么会输出这个结果？第二个线程怎么会在第一个线程释放锁之前得到了锁？原因在于，
 * 在insert方法中的lock变量是局部变量，每个线程执行该方法时都会保存一个副本，
 * 那么理所当然每个线程执行到lock.lock()处获取的是不同的锁，所以就不会发生冲突。
 *
 * 只需要将 lock 声明为类的属性即可
 *
 */
public class LockTest_2 {

    Lock lock = new ReentrantLock();
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        final LockTest_2 test = new LockTest_2();

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