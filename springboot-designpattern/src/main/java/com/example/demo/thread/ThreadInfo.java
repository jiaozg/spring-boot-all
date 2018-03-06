package com.example.demo.thread;

public class ThreadInfo {

    public static void main(String[] args) {
        
        Thread t1 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                synchronized (ThreadInfo.class) {
                    System.out.println("Thread");
                }
            }
        });
        
        t1.start();
        
        
        System.out.println(t1.getId());
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());//优先级 1-10
        System.out.println(t1.getState());//线程状态: NEW TERMINATED RUNNABLE TIMED_WAITING WAITING BLOCKED
    }
}