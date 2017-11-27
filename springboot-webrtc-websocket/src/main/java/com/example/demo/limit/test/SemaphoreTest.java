package com.example.demo.limit.test;

import com.example.demo.limit.SemaphoreLimitService;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaozhiguang on 2017/11/23.
 */
public class SemaphoreTest {

    public static SemaphoreLimitService semaphoreLimitService = new SemaphoreLimitService();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        boolean acquire = semaphoreLimitService.acquire();
                        if (acquire) {
                            System.out.println("没有限流，执行业务逻辑");
                            Thread.sleep(new Random().nextInt(200));
                        } else {
                            System.err.println("我被限流了");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        semaphoreLimitService.release();
                    }

                }
            });
        }
    }
}
