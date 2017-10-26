package com.example.demo.test;

/**
 * Created by jiaozhiguang on 2017/10/23.
 */
public class Child extends Parent {

    public String c = "child";
    private static String sc = "s child";

    public void method() {
        System.out.println(c);
    }

    public static void smethod() {
        System.out.println(sc);
    }

    public static void main(String[] args) {
        Child child = new Child();


    }

}
