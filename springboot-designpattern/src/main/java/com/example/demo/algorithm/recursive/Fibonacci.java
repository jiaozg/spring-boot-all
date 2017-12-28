package com.example.demo.algorithm.recursive;

import sun.jvm.hotspot.HelloWorld;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaozhiguang on 2017/12/22.
 */
public class Fibonacci {

    public static void main(String[] args) {

        int n = 10;

        System.out.println(HelloWorld.fib(n));

        testRecursive(n);

        testCalcWithoutRecursion(n);
    }

    public static void testRecursive(int n) {
        long begin = System.nanoTime();
        long f = Fibonacci.calc(n);
        long end = System.nanoTime();
        System.out.println(" 第" + n + "个斐波那契数是" + f + ", 耗时" + TimeUnit.NANOSECONDS.toMillis(end - begin) + "毫秒");
    }

    public static void testCalcWithoutRecursion(int n) {
        long begin = System.nanoTime();
        BigInteger f = Fibonacci.calcWithoutRecursionBig(n);
        System.out.println(f);
        long end = System.nanoTime();
        System.out.println("第" + n + "个斐波那契数是" + f + ", 耗时" + TimeUnit.NANOSECONDS.toMillis(end - begin) + "毫秒");
    }

    public static long calc(long n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return calc(n - 1) + calc(n - 2);
        }
    }

    public static long calcWithoutRecursion(long n) {
        if(n < 0)
            return 0;
        if(n == 0 || n == 1) {
            return n;
        }
        long fib = 0;
        long fibOne = 1;
        long fibTwo = 1;
        for(long i = 2; i <= n; i++) {
            fib = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fib;
        }
        return fib;
    }

    public static BigInteger calcWithoutRecursionBig(long n) {
        if(n < 0)
            return new BigInteger("0");
        if(n == 0 || n == 1) {
            return new BigInteger("1");
        }
        BigInteger fib = new BigInteger("0");
        BigInteger fibOne = new BigInteger("1");
        BigInteger fibTwo = new BigInteger("1");
        for(long i = 2; i <= n; i++) {
            fib = fibOne.add(fibTwo);
            fibTwo = fibOne;
            fibOne = fib;
        }
        return fib;
    }

}
