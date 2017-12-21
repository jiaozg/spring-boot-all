package com.example.demo.orderno.task;

import com.example.demo.orderno.service.OrderService;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderTask implements Runnable {

    CountDownLatch latch;
    OrderService orderService;

    public OrderTask(CountDownLatch latch, OrderService orderService) {
        this.latch = latch;
        this.orderService = orderService;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 订单号 " + orderService.getOrderNo());
    }
}
