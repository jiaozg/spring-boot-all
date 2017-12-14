package com.example.demo.thread.producerconsumer.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 用BlockingQueue实现

 BlockingQueue是一个阻塞队列，也是面试官常喜欢问的一个点。BlockingQueue是线程安全的，内部可以自动调用wait()，notify()方法。在多线程环境下，我们可以使用BlockingQueue去完成数据的共享，同时可以兼顾到效率和线程安全。

 如果生产者生产商品的速度远大于消费者消费的速度，并且生产的商品累积到一定的数量，已经超过了BlockingQueue的最大容量，那么生产者就会被阻塞。那为什么时候撤销生产者的阻塞呢？只有消费者开始消费累积的商品，且累积的商品数量小于BlockingQueue的最大容量，才能撤销生产者的阻塞。

 如果库存为0的话，消费者自动被阻塞。只有生产者生产出商品，才会撤销消费者的阻塞。
 */
public class Storage {

    private BlockingQueue<Product> queues = new LinkedBlockingQueue<Product>(10);

    public void push(Product p) throws InterruptedException {
        queues.put(p);
    }

    public Product pop() throws InterruptedException {
        return queues.take();
    }
}