package com.example.demo.thread.deadlock;

/**
 *
 死锁产生的原因以及四个必要条件
 产生死锁的原因：

 系统资源不足。
 资源分配不当。
 进程运行推进的顺序不合适。
 发生死锁的必要条件：

 互斥条件： 一个资源只能被一个进程占用，直到被该进程释放。

 请求和保持条件：一个进程因请求被占用资源而发生阻塞时，对已获得的资源保持不放。

 不可剥夺条件：任何一个资源在没被该进程释放之前，任何其他进程都无法对它进行剥夺占用。

 循环等待条件：当发生死锁时，所等待的进程必定会发生环路，造成永久阻塞。

 防止死锁的一些方法：

 破除互斥等待：一般无法做到。

 破除请求和保持：一次性获取所有的资源。

 破除循环等待：按顺序获取资源。

 破除无法剥夺的等待：加入超时机制。


 */
public class DeadLockDemo {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        Thread a = new Thread(new LockThread1());
        Thread b = new Thread(new LockThread2());
        a.start();
        b.start();
    }
}

class LockThread1 implements Runnable {

    @Override
    public void run() {

        System.out.println("lockThread1 running");
        while (true) {
            synchronized (DeadLockDemo.obj1) {
                System.out.println("lockThrea1 lock obj1");
                try {
                    Thread.sleep(3000);
                    synchronized (DeadLockDemo.obj2) {
                        System.out.println("lockThrea1 lock obj2");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

class LockThread2 implements Runnable {

    @Override
    public void run() {

        System.out.println("lockThread2 running");
        while (true) {
            synchronized (DeadLockDemo.obj2) {
                System.out.println("lockThrea2 lock obj2");
                try {
                    Thread.sleep(3000);
                    synchronized (DeadLockDemo.obj1) {
                        System.out.println("lockThrea2 lock obj1");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}