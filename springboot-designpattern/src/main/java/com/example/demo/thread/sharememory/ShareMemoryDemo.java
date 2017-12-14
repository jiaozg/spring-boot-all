package com.example.demo.thread.sharememory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/10/12.
 * 每个线程表示一条单独的执行流，有自己的程序计数器，有自己的栈，但线程之间可以共享内存，它们可以访问和操作相同的对象
 */
public class ShareMemoryDemo {

    private static int shared = 0;

    private static void incrShared(){
        shared ++;
    }

    static class ChildThread extends Thread {
        List<String> list;

        public ChildThread(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            incrShared();
            list.add(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        Thread t1 = new ChildThread(list);
        Thread t2 = new ChildThread(list);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(shared);
        System.out.println(list);
    }

}
