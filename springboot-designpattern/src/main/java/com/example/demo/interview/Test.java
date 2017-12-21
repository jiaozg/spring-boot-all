package com.example.demo.interview;

import java.lang.reflect.Field;

/**
 * Created by jiaozhiguang on 2017/12/18.
 *
 * 1 值传递 引用
 * 2 反射
 * 3 IntegerCache
 * 4 装箱 拆箱
 *
 */
public class Test {

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;

        System.out.println("before swap a =" + a +" b = " + b);

        swap(a, b);

        System.out.println("before swap a =" + a +" b = " + b);
    }

    public static void swap(Integer num1, Integer num2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            int tmp = num1.intValue();
//            field.setAccessible(true);
            field.set(num1, num2);
            field.set(num2, tmp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
