package com.example.demo.test;

/**
 * Created by jiaozhiguang on 2017/10/17.
 */
public class Test {


    public static void main(String[] args) {

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int code = i * 16 + j;
                System.out.printf("\u001b[38;5;%dm%-4d", code, code);
            }
            System.out.println("\u001b[0m");
        }


        testFloat();

    }

    public static void testFloat() {
        float x;
        x = 10/4;
        System.out.println("10/4 = " + x);
        x = 10/4.0f;
        System.out.println("10/4.0f = " + x);
        x = 10.0f/4;
        System.out.println("10/4.0f = " + x);
        x = 10.0f/4.0f;
        System.out.println("10.0f/4.0f = " + x);

        System.out.println(1/2);
        System.out.println(1/2*9);

        System.out.println(7.7%3);
    }


}
