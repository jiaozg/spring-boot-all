package com.example.demo.thread.memoryvisibility;

/**
 * Created by jiaozhiguang on 2017/10/12.
 * 多个线程可以共享访问和操作相同的变量，但一个线程对一个共享变量的修改，另一个线程不一定马上就能看到，甚至永远也看不到
 *
 * 期望的结果是两个线程都退出，但实际执行，很可能会发现HelloThread永远都不会退出，也就是说，在HelloThread执行流看来，
 * shutdown永远为false，即使main线程已经更改为了true 这就是内存可见性问题
 */
public class VisibilityDemo  {

    private static boolean shutdown = false;

    static class HelloThread extends Thread {
        @Override
        public void run() {
            while(!shutdown){
                // do nothing
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }

}
