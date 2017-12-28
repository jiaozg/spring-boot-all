package com.example.demo.aop;

public class AopImpl implements Aop {
    @Override
    public String getClassName() {

        return this.getClass().getName();
    }
}