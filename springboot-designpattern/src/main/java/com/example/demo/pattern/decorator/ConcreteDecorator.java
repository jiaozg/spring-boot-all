package com.example.demo.pattern.decorator;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator() {
        super();
    }

    public ConcreteDecorator(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {

        super.sampleOperation();

        System.out.println("decorator business");
    }

}
