package com.example.demo;

/**
 * Created by jiaozhiguang on 2018/2/8.
 */
public class Test {

    public static void main(String[] args) {
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 =Integer.valueOf(59);
        Integer i04 = new Integer(59);

        System.out.println(i01 == i02);
        System.out.println(i01 == i03);
        System.out.println(i02 == i04);
        System.out.println(i02 == i04);
    }

}
