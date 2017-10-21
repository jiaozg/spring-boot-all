package com.example.demo.pattern.stratege.s2;

/**
 * Created by jiaozhiguang on 2017/10/19.
 */
public class DisabledDuck extends Duck implements Quackable {


    @Override
    public void display() {
        System.out.println("残废鸭的颜色...");
    }

    @Override
    public void quack() {

    }
}
