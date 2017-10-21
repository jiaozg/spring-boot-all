package com.example.demo.pattern.observer;

/**
 * Created by jiaozhiguang on 2017/10/20.
 */
public interface Subject {

    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notice();

}
