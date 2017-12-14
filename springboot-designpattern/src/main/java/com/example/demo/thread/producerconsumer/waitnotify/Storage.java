package com.example.demo.thread.producerconsumer.waitnotify;

public class Storage {

    private int MAX_SIZE = 20;

    private int count = 0;

    public synchronized void cosume() {
        while (count == 0) {
            try {
                System.out.println("【消费者】库存已经为空了，暂时不能进行消费任务!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        System.out.println("【消费者】" + Thread.currentThread().getName() + "消费产品, 库存:" + count);
        this.notify();
    }

    public synchronized void produce() {
        while (count >= MAX_SIZE) {
            try {
                System.out.println("【生产者】库存已经满了，暂时不能进行生产任务！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;
        System.out.println("【生产者】" + Thread.currentThread().getName() + "生产产品, 库存" + count);
        this.notify();
    }
}