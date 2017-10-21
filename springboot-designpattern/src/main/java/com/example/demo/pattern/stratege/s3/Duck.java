package com.example.demo.pattern.stratege.s3;

/**
 * Created by jiaozhiguang on 2017/10/20.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}
    public abstract void display();
    public void swim(){
        //实现游泳的行为
    }
    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    public void setQuackBehavior(QuackBehavior quackBehavior)  {
        this.quackBehavior= quackBehavior;
    }

}
