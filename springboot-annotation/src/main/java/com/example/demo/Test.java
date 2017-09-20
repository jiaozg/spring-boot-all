package com.example.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by jiaozhiguang on 2017/9/20.
 */
public class Test {

    public static void main(String[] args) {
        try {
            //获取类MyClass的注解
            Class class0 = Class.forName("com.example.demo.MyClass");
            Annotation[] annotations = class0.getAnnotations();
            for (Annotation annotation:annotations) {
                if(annotation instanceof MyAnnotation){
                    System.out.println("MyClass:"+((MyAnnotation) annotation).test());
                }
            }
            //获取类MyClass中方法的注解
            Method[] methods = class0.getMethods();
            for(Method method:methods){
                if(method.isAnnotationPresent(MyAnnotation.class)){
                    MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                    System.out.println("MyClass:"+myAnnotation.test());
                }
            }
            //获取类MyClass子类MySubClass的注解
            Class class1 = MySubClass.class;
            if(class1.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation myAnnotation = (MyAnnotation) class1.getAnnotation(MyAnnotation.class);
                System.out.println("MySubClass:"+myAnnotation.test());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
