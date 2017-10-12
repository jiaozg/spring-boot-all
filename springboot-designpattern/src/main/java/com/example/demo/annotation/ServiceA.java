package com.example.demo.annotation;

public class ServiceA {

    @SimpleInject
    ServiceB b;
    
    public void callB(){
        b.action();
    }
}