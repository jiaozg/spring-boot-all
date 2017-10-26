package com.example.demo.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by jiaozhiguang on 2017/10/17.
 */
public class Test {

    static int[] arr = new int[10];

    public static void main(String[] args) {


        BigDecimal b1 = new BigDecimal("20").divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

        System.out.println(b1);

//        String a = "abc";
//        String b = "abc";
//
//        System.out.println(a == b);
//        System.out.println(a.equals(b));


//        int i = 0;
//        for( ; i<4; i+=2) {
//            System.out.print( i + " ");
//        }

//        int i = 1, j=10;
//        do {
//            if (i > --j) {
//                continue;
//            }
//        } while (i++ < 5);
//
//        System.out.println("i = " + i + " and j  = " + j);




//        System.out.println(3*0.1 == 0.3);
//        System.out.println(-1>>1);
//        System.out.println(-1>>>1);
//        System.out.println(2>>1);
//        System.out.println(2>>>1);
//
//        System.out.println(arr[1]);
//
//        System.out.println("##########");
//
//        System.out.println(foo(50));
//
//        System.out.println(Integer.toBinaryString(48));
//        System.out.println(Integer.toBinaryString(47));
//
//        System.out.println(Integer.toBinaryString(32));
//        System.out.println(Integer.toBinaryString(31));

    }

    public static int foo(int x) {
        int count=0;
        while(x>0){
            count++;
            x = x & (x - 1);
        }
        return count;
    }
}
