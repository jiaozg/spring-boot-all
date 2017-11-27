package com.example.demo.limit;

import java.util.concurrent.Semaphore;

/**
 * Created by jiaozhiguang on 2017/11/23.
 */
public class SemaphoreLimitService implements LimitService{

    Semaphore semaphore = new Semaphore(10);

    @Override
    public boolean acquire() {
        return semaphore.tryAcquire();
    }

    @Override
    public void release() {
        semaphore.release();
    }
}
