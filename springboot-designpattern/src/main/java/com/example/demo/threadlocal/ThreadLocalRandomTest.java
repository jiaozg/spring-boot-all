package com.example.demo.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * ThreadLocalRandom
 即使对象是线程安全的，使用ThreadLocal也可以减少竞争，比如，Random类，
 Random是线程安全的，但如果并发访问竞争激烈的话，性能会下降，所以Java并发包提供了类ThreadLocalRandom，
 它是Random的子类，利用了ThreadLocal，它没有public的构造方法，通过静态方法current获取对象
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        System.out.println(rnd.nextInt());
    }
}
