package com.example.demo.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/13.
 */
public class Department {


    private int id;
    private String name;
    private List<Department> child = new ArrayList<>();
    private int pid;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getChild() {
        return child;
    }

    public void setChild(List<Department> child) {
        this.child = child;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }






}
