package com.example.demo.pattern.stratege.s2;

/**
 * Created by jiaozhiguang on 2017/10/19.
 */
public abstract class Duck {


    public void swim(){   //游泳
        System.out.println(" 游泳");
    }
    public abstract void display(); /*因为外观不一样，让子类自己去决定了。*/

}
