package com.example.demo.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * 第三次执行异步任务，结果就不对了，为什么呢？因为线程池中的线程在执行完一个任务，执行下一个任务时，
 * 其中的ThreadLocal对象并不会被清空，修改后的值带到了下一个异步任务。那怎么办呢？有几种思路：
 第一次使用ThreadLocal对象时，总是先调用set设置初始值，或者如果Threa
 Local重写了initialValue方法，先调用remove
 使用完ThreadLocal对象后，总是调用其remove方法
 使用自定义的线程池
 */
public class ThreadPoolProblem {

    static ThreadLocal<AtomicInteger> sequencer = new ThreadLocal<AtomicInteger>() {

        @Override
        protected AtomicInteger initialValue() {
            return new AtomicInteger(0);
        }
    };

    static class Task implements Runnable {

        @Override
        public void run() {
            AtomicInteger s = sequencer.get();
            int initial = s.getAndIncrement();
            // 期望初始为0
            System.out.println(initial);
        }
    }

//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.execute(new Task());
//        executor.execute(new Task());
//        executor.execute(new Task());
//        executor.shutdown();
//    }

    public static void main(String[] args) {
        ExecutorService executor = new MyThreadPool(2, 2, 0,
                TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        executor.execute(new Task());
        executor.execute(new Task());
        executor.execute(new Task());
        executor.shutdown();
    }

}
