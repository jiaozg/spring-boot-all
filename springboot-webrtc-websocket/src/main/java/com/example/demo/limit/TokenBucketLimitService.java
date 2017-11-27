package com.example.demo.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by jiaozhiguang on 2017/11/23.
 */
public class TokenBucketLimitService implements LimitService {

    /**
     * guava 每秒500个
     *
     * 可以把RateLimiter放到ConcurrentHashMap 里面
     */
    static RateLimiter rateLimiter = RateLimiter.create(500);

    @Override
    public boolean acquire() {
        return rateLimiter.tryAcquire();
    }

    @Override
    public void release() {
    }
}
