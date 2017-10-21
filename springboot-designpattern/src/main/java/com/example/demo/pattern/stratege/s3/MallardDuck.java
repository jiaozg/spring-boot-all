package com.example.demo.pattern.stratege.s3;

/**
 * Created by jiaozhiguang on 2017/10/20.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display(){
        //实现
    }

}
