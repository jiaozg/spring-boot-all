package com.example.demo.datastructure.recursion;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    public static long factorial(int n) {
        if(1 == n) {
            return n;
        }else {
            return factorial(n-1) + n;
        }
    }
}
