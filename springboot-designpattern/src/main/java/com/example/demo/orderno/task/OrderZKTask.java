package com.example.demo.orderno.task;

import com.example.demo.orderno.service.OrderService;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderZKTask implements Runnable {

    CountDownLatch latch;
    OrderService orderService;

    InterProcessMutex interProcessMutex;

    public OrderZKTask(CountDownLatch latch, OrderService orderService, InterProcessMutex interProcessMutex) {
        this.latch = latch;
        this.orderService = orderService;
        this.interProcessMutex = interProcessMutex;
    }

    @Override
    public void run() {
        try {
            latch.await();
            interProcessMutex.acquire();
            System.out.println(Thread.currentThread().getName() + " 订单号 " + orderService.getOrderNo());
            interProcessMutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
