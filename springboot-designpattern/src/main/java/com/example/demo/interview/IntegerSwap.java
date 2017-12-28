package com.example.demo.interview;

import java.lang.reflect.Field;

/**
 * Created by jiaozhiguang on 2017/12/28.
 */
public class IntegerSwap {


    public static void main(String[] args) throws Exception {

        System.out.println(Integer.MAX_VALUE);

        Integer i1 = 222;
        Integer i2 = 333;

        swap(i1, i2);

        System.out.println(i1 == i2);

        System.out.println("i1 =" + i1 + " i2 = " + i2);

    }

    public static void swap(Integer num1, Integer num2) throws Exception {

        Field field = Integer.class.getDeclaredField("value");
        int tmp = num1.intValue();
        field.setAccessible(true);
        field.set(num1, num2);
        field.set(num2, tmp);
    }

}
