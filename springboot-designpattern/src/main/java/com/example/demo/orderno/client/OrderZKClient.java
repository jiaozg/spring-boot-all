package com.example.demo.orderno.client;

import com.example.demo.orderno.service.OrderService;
import com.example.demo.orderno.service.impl.OrderNoLockServiceImpl;
import com.example.demo.orderno.task.OrderZKTask;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderZKClient {

    private static final String ZK_ADDRESS = "localhost:2181";
    private static final String ZK_LOCK_PATH = "/zktest/lock0";

    final static CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));

    public static void main(String[] args) throws InterruptedException {
        client.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(1);
        final InterProcessMutex lock = new InterProcessMutex(client, ZK_LOCK_PATH);
        OrderService orderService = new OrderNoLockServiceImpl();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new OrderZKTask(latch, orderService, lock));
        }
        latch.countDown();
        executorService.shutdown();
    }

}
