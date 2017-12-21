package com.example.demo.orderno.client;

import com.example.demo.orderno.service.OrderService;
import com.example.demo.orderno.service.impl.OrderRedisServiceImpl;
import com.example.demo.orderno.task.OrderTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderRedisClient {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(1);
        OrderService orderService = new OrderRedisServiceImpl();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new OrderTask(latch, orderService));
        }
        latch.countDown();
        executorService.shutdown();
    }

}
