package com.example.demo.thread.pool.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2018/1/23.
 *
 *
 * public static ExecutorService newFixedThreadPool(int nThreads) {
 return new ThreadPoolExecutor(nThreads, nThreads,
 0L, TimeUnit.MILLISECONDS,
 new LinkedBlockingQueue<Runnable>());
 }
 */
public class TestFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }

}
