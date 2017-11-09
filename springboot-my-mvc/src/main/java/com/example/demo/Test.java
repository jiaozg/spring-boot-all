package com.example.demo;

import com.example.demo.controller.IndexController;
import com.example.demo.annotation.MyController;
import com.example.demo.annotation.MyRequestMapping;

import java.lang.reflect.Method;

/**
 * Created by jiaozhiguang on 2017/11/4.
 */
public class Test {


    public static void main(String[] args) {

        Class clazz = IndexController.class;
        String path = "";
        if (clazz.isAnnotationPresent(MyController.class)) {
            System.out.println(clazz.getName() + "被标记为控制器");
            MyRequestMapping reqAnno = (MyRequestMapping) clazz.getAnnotation(MyRequestMapping.class);
            path = reqAnno.value();
        }
        Method [] methods = clazz.getMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                continue;
            }
            System.out.println(path + method.getAnnotation(MyRequestMapping.class).value());
        }

    }

}
