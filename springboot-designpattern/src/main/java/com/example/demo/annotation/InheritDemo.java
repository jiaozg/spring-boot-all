package com.example.demo.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * Test是一个注解，类Base有该注解，Child继承了Base但没有声明该注解，main方法检查Child类是否有Test注解，输出为true，
 * 这是因为Test有注解@Inherited，如果去掉，输出就变成false了。
 */
public class InheritDemo {

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    static @interface Test {
    }

    @Test
    static class Base {
    }

    static class Child extends Base {
    }

    public static void main(String[] args) {
        System.out.println(Child.class.isAnnotationPresent(Test.class));
    }
}
