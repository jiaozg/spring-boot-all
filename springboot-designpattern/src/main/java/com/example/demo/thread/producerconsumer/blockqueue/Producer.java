package com.example.demo.thread.producerconsumer.blockqueue;

public class Producer implements Runnable {

    private String name;
    private Storage storage = null;

    public Producer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                System.out.println(name + "已经生产一个: id为" + i + "的商品");
                System.out.println("===========================");

                Product product = new Product(i++);

                storage.push(product);

                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}