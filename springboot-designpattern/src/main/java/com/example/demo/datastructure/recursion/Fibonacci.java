package com.example.demo.datastructure.recursion;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static long fibonacci(int n) {
        if((0 == n) || (1 == n)) {
            return n;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
