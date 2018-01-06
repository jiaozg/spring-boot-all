package com.example.demo.pattern.decorator;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA() {
        super();
    }

    public ConcreteDecoratorA(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {

        super.sampleOperation();

        System.out.println("decorator A business");
    }

}
