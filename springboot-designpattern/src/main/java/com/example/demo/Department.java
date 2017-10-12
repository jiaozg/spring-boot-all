package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/9/26.
 */
public class Department {

    int getCount() {
        return 1;
    }

    public List<Department> getChildren() {
        return children;
    }

    List<Department> children = new ArrayList<>();

    int all = 0;

    public int getAllCount(Department dep) {
        all += dep.getCount();
        for (Department department : dep.getChildren()) {
            getAllCount(department);
        }
        return all;
    }


    public static void main(String[] args) {

        Department department = new Department();
        Department child1 = new Department();
        Department child2 = new Department();
        Department child3 = new Department();
        department.children.add(child1);
        department.children.add(child2);
        department.children.add(child3);

        Department child11 = new Department();
        Department child12 = new Department();
        Department child13 = new Department();

        child1.children.add(child11);
        child1.children.add(child12);
        child1.children.add(child13);

        System.out.println(department.getAllCount(department));
    }
}


