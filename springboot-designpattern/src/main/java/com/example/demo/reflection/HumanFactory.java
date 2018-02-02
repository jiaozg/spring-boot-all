package com.example.demo.reflection;

/**
 * Created by jiaozhiguang on 2018/1/17.
 */
public class HumanFactory {

//    public staticproxy Human getInstance(String name) {
//        if (name.equalsIgnoreCase("Student")) {
//            return new Student();
//        } else if (name.equalsIgnoreCase("Teacher")) {
//            return new Teacher();
//        }
//    }

    public static Human getInstance(String className) {
        Human human = null;
        try {
            human =  (Human) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return human;
    }

}
