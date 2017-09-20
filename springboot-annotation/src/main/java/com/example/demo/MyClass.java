package com.example.demo;

/**
 * Created by jiaozhiguang on 2017/9/20.
 */
@MyAnnotation(test = "类注解")
public class MyClass{
    @MyAnnotation(test = "方法注解")
    public void myMethod(){

    }
}
