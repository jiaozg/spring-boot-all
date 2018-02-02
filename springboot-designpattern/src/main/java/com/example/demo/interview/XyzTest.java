package com.example.demo.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2018/1/10.
 */
public class XyzTest {

    public static void main(String[] args) {

        Integer x = 5;
        int y = 5;
        System.out.println(x == y);

        List<Integer> list = new ArrayList<>();

        for (int i = 100; i < 999 ; i++) {
            int a = i/100;
            int b = i%100/10;
            int c = i%100%10;

            double sum = Math.pow(a, 3) + Math.pow(a, 3) +  Math.pow(a, 3);

            if (sum == i) {
                list.add(i);
            }

        }

        System.out.println(list);
            
    }

}
