package com.example.demo.interview;

/**
 * Created by jiaozhiguang on 2018/1/2.
 *
 * 静态变量的声明与初始化是两个不同的操作；
 */
public class IntTest {

    private static IntTest test = new IntTest();

    static int a1;

    static int a2 = 20;

    IntTest() {
        a1++;
        a2++;
    }

//    static {
//        a1 = 1;
//        a2 = 1;
//        a2 = 20;
//    }

    public static void main(String[] args) {

        System.out.println(IntTest.a1);
        System.out.println(IntTest.a2);

    }

}
