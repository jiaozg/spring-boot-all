package com.example.demo;

import java.util.Calendar;

/**
 * Created by jiaozhiguang on 2017/11/8.
 */
public class Test {


    public static void main(String[] args) {

        System.out.println(Calendar.getInstance().get(Calendar.YEAR));


        for (int i = 1; i < 3 ; i++) {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            year-=i;
            System.out.println(year);
        }
    }
}
