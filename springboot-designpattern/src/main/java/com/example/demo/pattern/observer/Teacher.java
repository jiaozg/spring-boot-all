package com.example.demo.pattern.observer;

import lombok.Data;

import java.util.Vector;

/**
 * Created by jiaozhiguang on 2017/10/20.
 */
@Data
public class Teacher implements Subject {

    private String phone;
    private Vector students;

    public Teacher(){
        phone = "";
        students = new Vector();
    }

    @Override
    public void attach(Observer observer) {
        students.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        students.remove(observer);
    }

    @Override
    public void notice() {
        for(int i=0;i<students.size();i++)
            ((Observer)students.get(i)).update();
    }

    public void setPhone(String phone){
        this.phone = phone;
        notice();    //关键
    }
}
