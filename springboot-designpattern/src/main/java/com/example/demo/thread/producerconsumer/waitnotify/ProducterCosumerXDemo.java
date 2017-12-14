package com.example.demo.thread.producerconsumer.waitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducterCosumerXDemo {

    public static void main(String[] args) {
        Storage storage = new Storage();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            service.submit(new Producter(storage));
        }

        for (int i = 0; i < 5; i++) {
            service.submit(new Consumer(storage));
        }

        service.shutdown();
    }
}