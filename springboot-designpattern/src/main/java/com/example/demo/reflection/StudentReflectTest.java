package com.example.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class Field Method Constructor
 * Class类的描述信息 元数据
 * 三种方式获取
 * 1，通过类名
 * 2，通过实例对象的getClass()方法
 * 3，Class.forName();
 */
public class StudentReflectTest {

    public static void main(String[] args) throws Exception {

        System.out.println("三种获取类信息方法");
        Class clazz = Student.class;
        clazz = new Student().getClass();
        clazz = Class.forName("com.example.demo.reflection.Student");

        Student student = (Student) clazz.newInstance();
        System.out.println(student);


        System.out.println("构造函数");
        Constructor constructor = clazz.getConstructor(int.class, String.class);
        student = (Student) constructor.newInstance(1, "a");
        System.out.println(student);

        System.out.println("所有字段");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("所有方法");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("属性更改和方法调用");

        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(student, "jiao");
        System.out.println(student);

        Method method =  clazz.getDeclaredMethod("setName", String.class);
        method.invoke(student, "zhiguang");
        System.out.println(student);

    }


}
