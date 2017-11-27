package com.example.demo.limit.test;

import com.example.demo.limit.CountLimitService;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2017/11/22.
 */
public class CountTest {

    public static CountLimitService countLimitService = new CountLimitService();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    boolean acquire = countLimitService.acquire();
                    if (acquire) {
                        System.out.println("没有限流，执行业务逻辑");
                        try {
                            Thread.sleep(new Random().nextInt(200));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("我被限流了");
                    }
                }
            });
        }
    }
}
