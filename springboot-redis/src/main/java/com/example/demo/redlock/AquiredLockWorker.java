package com.example.demo.redlock;

/**
 * 获取锁后需要处理的逻辑
 * @param <T>
 */
public interface AquiredLockWorker<T> {
     T invokeAfterLockAquire() throws Exception;
}