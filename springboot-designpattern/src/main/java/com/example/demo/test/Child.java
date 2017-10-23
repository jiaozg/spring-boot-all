package com.example.demo.test;

/**
 * Created by jiaozhiguang on 2017/10/23.
 */
public class Child extends Person {

    public String grade;

    public Child() {
        System.out.println();
        super();
    }

    public static void main(String[] args) {
        Person person = new Child();
//        System.out.println(person.name);
    }

}
