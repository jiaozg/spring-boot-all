package com.example.demo.interview;

import java.lang.reflect.Field;

/**
 * Created by jiaozhiguang on 2017/12/18.
 1,Java 传值方式
    值传递
    引用传递

 2,装箱 拆箱
 查看字节码命令：javap -c IntegerTest.class

 3,反射

 4,IntegerCache -128 127
 new Integer()
 Field.setInt



 *
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 2;

        System.out.println(b == c);

        System.out.println("after a = " + a + " b= " + b);
        swap(a, b);
        System.out.println("after a = " + a + " b= " + b);

        swapReflect(a, b);
        System.out.println("after a = " + a + " b= " + b);
    }

    public static void swap(Integer num1, Integer num2) {
        Integer tmp;
        tmp = num1;
        num1 = num2;
        num2 = tmp;

    }

    public static void swapReflect(Integer num1, Integer num2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = num1.intValue();
            Integer bb = 1;
            System.out.println("bb : " + bb);
            field.set(num1, num2);
            Integer aa = 1;
            System.out.println("aa:"+aa);
            field.set(num2, new Integer(tmp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
