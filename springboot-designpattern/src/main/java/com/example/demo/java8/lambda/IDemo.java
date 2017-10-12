package com.example.demo.java8.lambda;

public interface IDemo {
    void hello();

    public static void test() {
        System.out.println("hello");
    }

    default void hi() {
        System.out.println("hi");
    }
}