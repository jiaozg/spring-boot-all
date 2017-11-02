package com.example.demo.algorithm;

/**
 * Created by jiaozhiguang on 2017/10/31.
 * 5！=5*4*3*2*1=120
 * 递归函数计算一个数的阶乘
 * 1。使用循环
 * 2。使用递归
 * 3。大数的阶乘如何处理 90！
 */
public class Factorial {

    public static void main(String[] args) {
        long factorial = 1;
        for (int i = 1; i <=5 ; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }


    public static long factorial(int num) {
        return 0L;
    }


}
