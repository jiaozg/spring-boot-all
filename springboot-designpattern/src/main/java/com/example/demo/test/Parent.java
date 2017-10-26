package com.example.demo.test;

/**
 * Created by jiaozhiguang on 2017/10/24.
 */
public class Parent {

    private String p = "parent";
    private static String sp = "s parent";

    public void method() {
        System.out.println(p);
    }

    public static void smethod() {
        System.out.println(sp);
    }

}
