package com.example.demo.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiaozhiguang on 2018/1/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Human {

    private int id;
    private String name;

    public void say() {
        System.out.println("I'm Student");
    }

}
