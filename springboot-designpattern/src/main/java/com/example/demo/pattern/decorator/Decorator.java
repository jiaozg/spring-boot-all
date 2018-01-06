package com.example.demo.pattern.decorator;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class Decorator implements Component{

    private Component component;

    public Decorator() {

    }

    public Decorator(Component component) {
        this.component = component;

    }

    @Override
    public void sampleOperation() {
        component.sampleOperation();
    }

}
