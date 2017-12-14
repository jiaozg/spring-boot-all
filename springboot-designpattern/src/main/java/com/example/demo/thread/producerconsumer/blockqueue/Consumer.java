package com.example.demo.thread.producerconsumer.blockqueue;

public class Consumer implements Runnable {

    private String name;
    private Storage storage = null;

    public Consumer(String name, Storage s) {
        this.name = name;
        this.storage = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Product product = storage.pop();

                System.out.println(name + "已经消费一个: id为" + product.getId() + "的商品");
                System.out.println("===========================");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}