package com.example.demo.threadlocal;

import java.lang.reflect.Field;
import java.util.concurrent.*;

/**
 * Created by jiaozhiguang on 2017/9/28.
 */
public class MyThreadPool extends ThreadPoolExecutor {

    public MyThreadPool(int corePoolSize, int maximumPoolSize,
                        long keepAliveTime, TimeUnit unit,
                        BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        try {
            //使用反射清空所有ThreadLocal
            Field f = t.getClass().getDeclaredField("threadLocals");
            f.setAccessible(true);
            f.set(t, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.beforeExecute(t, r);
    }



}
