package com.example.demo.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by jiaozhiguang on 2017/9/29.
 */
public class DirectMem {

    public static void main(String[] args) {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
//        field.set
    }
}
