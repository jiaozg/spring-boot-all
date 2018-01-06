package com.example.demo.pattern.decorator;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class DecoratorTest {


    public static void main(String[] args) {

        Component component = new ConcreteComponent();

        Decorator decorator = new ConcreteDecorator(component);

        Decorator decoratorA = new ConcreteDecoratorA(component);

        decorator.sampleOperation();
        System.out.println();
        decoratorA.sampleOperation();

    }

}
