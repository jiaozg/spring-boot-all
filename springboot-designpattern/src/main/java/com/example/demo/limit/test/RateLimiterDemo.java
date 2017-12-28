package com.example.demo.limit.test;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaozhiguang on 2017/11/23.
 */
public class RateLimiterDemo {

    public static ConcurrentHashMap<String, RateLimiter> concurrentHashMap
            = new ConcurrentHashMap<>();

    static{
        createRateLimiter("order", 50);
    }

    public static void createRateLimiter(String resource, int qps) {
        if (concurrentHashMap.contains(resource)) {
            concurrentHashMap.get(resource).setRate(qps);
        } else {
            RateLimiter rateLimiter = RateLimiter.create(qps);
            concurrentHashMap.putIfAbsent(resource, rateLimiter);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            new Thread(() -> {
                if (concurrentHashMap.get("order").tryAcquire(10, TimeUnit.MILLISECONDS)) {
                    System.out.println("执行业务逻辑");
                } else {
                    System.err.println("限流");
                }
            }).start();
        }
    }
}
