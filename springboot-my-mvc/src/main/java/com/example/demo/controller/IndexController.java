package com.example.demo.controller;

import com.example.demo.annotation.MyController;
import com.example.demo.annotation.MyRequestMapping;

/**
 * Created by jiaozhiguang on 2017/11/3.
 */
@MyController
@MyRequestMapping("/jiao")
public class IndexController {

    @MyRequestMapping("/index")
    public void index() {

    }

    @MyRequestMapping("/add")
    public void add() {

    }

    @MyRequestMapping("/edit")
    public void edit() {

    }

    @MyRequestMapping("/delete")
    public void delete() {

    }

    public void test() {

    }
}
