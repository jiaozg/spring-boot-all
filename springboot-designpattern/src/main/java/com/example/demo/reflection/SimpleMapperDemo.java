package com.example.demo.reflection;

/**
 * Created by jiaozhiguang on 2017/9/28.
 */
public class SimpleMapperDemo {

    static class Student {
        String name;
        int age;
        Double score;

        public Student() {
        }

        public Student(String name, int age, Double score) {
            super();
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
        }
    }

    public static void main(String[] args) {
        Student zhangsan = new Student("张三", 18, 89d);
        String str = SimpleMapper.toString(zhangsan);
        System.out.println(str);
        Student zhangsan2 = (Student) SimpleMapper.fromString(str);
        System.out.println(zhangsan2);
    }

}
