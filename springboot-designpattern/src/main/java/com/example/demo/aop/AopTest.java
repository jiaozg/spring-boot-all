package com.example.demo.aop;

/**
 * Created by jiaozhiguang on 2017/12/22.
 */
public class AopTest {

    public static void main(String[] args) {

        Aop aopProxy = new AopProxy(new AopImpl()).createProxy();
        System.out.println(aopProxy.getClassName());
    }

}
