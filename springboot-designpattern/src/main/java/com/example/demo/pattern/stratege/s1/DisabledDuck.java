package com.example.demo.pattern.stratege.s1;

/**
 * Created by jiaozhiguang on 2017/10/19.
 */
public class DisabledDuck extends Duck {

    public void display(){
        System.out.println("残废鸭的颜色...");
    }

    public void fly(){
        //覆盖，变成什么事都不做。
    }

}
