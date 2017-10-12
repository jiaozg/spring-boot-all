package com.example.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/9/28.
 */
public class ReflectionTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        List<String> obj = Arrays.asList(new String[]{"老马","编程"});
        Class<?> cls = obj.getClass();
        for(Field f : cls.getDeclaredFields()){
            f.setAccessible(true);
            System.out.println(f.getName()+" - "+f.get(obj));
        }


        cls = Integer.class;
        try {
            Method method = cls.getMethod("parseInt", new Class[]{String.class});
            System.out.println(method.invoke(null, "123"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Constructor<StringBuilder> contructor= StringBuilder.class.getConstructor(new Class[]{int.class});
        StringBuilder sb = contructor.newInstance(100);


        localClass();
    }

    public static void localClass(){
        class MyLocal {
        }
        Runnable r = new Runnable() {
            @Override
            public void run(){

            }
        };
        System.out.println(MyLocal.class.isLocalClass());
        System.out.println(r.getClass().isLocalClass());
    }

}
