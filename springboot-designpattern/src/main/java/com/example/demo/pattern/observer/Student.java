package com.example.demo.pattern.observer;

/**
 * Created by jiaozhiguang on 2017/10/20.
 */
public class Student implements Observer {

    private String name;
    private String phone;
    private Teacher teacher;

    public Student(String name,Teacher t){
        this.name = name;
        teacher = t;
    }

    public void show(){
        System.out.println("Name:"+name+"\nTeacher'sphone:"+phone);
    }

    @Override
    public void update() {
        phone = teacher.getPhone();
    }
}
