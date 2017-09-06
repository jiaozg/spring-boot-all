package com.example.demo.redlock;

/**
 * Created by jiaozhiguang on 2017/9/2.
 * 获取锁后需要处理的逻辑
 */
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}
