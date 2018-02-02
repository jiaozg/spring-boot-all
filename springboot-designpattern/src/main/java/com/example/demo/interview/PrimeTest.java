package com.example.demo.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2018/1/22.
 * 判断101-200之间有多少个素数，并输出所有素数。

 程序分析：判断素数的方法——所谓素数是指除了1和它本身以外，不能被任何整数整除的数，例如17就是素数，
 因为它不能被2~16的任一整数整除。
 */
public class PrimeTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i = 101; i < 200; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
            if (isPrime2(i)) {
                list2.add(i);
            }
            if (isPrime3(i)) {
                list3.add(i);
            }
        }

        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number-1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int number) {
        for (int i = 2; i < number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime3(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
