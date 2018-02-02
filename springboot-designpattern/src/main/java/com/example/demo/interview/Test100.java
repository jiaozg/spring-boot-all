package com.example.demo.interview;

import java.math.BigDecimal;

/**
 * Created by jiaozhiguang on 2018/1/22.
 * 一个求从
 */
public class Test100 {

    public static void main(String[] args) {
        System.out.println(getHeight(100, 9));
        System.out.println(paths(100, 12));
    }

    public static BigDecimal paths(int height, int n) {
        BigDecimal sum = new BigDecimal(height);
        BigDecimal temp = new BigDecimal(height);
        for (int i = 1; i < n; i++) {
            temp = temp.divide(new BigDecimal(2));
            sum = sum.add(temp.multiply(new BigDecimal(2)));
        }
        return sum;
    }

    public static BigDecimal getHeight(int height, int n) {
        BigDecimal temp = new BigDecimal(height);
        for (int i = 1; i < n; i++) {
            temp = temp.divide(new BigDecimal(2));
        }
        return temp;
    }

}
