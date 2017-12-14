package com.example.demo.thread.producerconsumer.blockqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducterConsumerDemo {

    public static void main(String[] args) {
        Storage storage = new Storage();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer p0 = new Producer("腾讯", storage);
        Consumer c0 = new Consumer("cmazxiaoma", storage);
        
        service.submit(p0);
        service.submit(c0);

        service.shutdown();

    }
}