package com.example.demo.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by jiaozhiguang on 2017/9/30.
 */
public class PredicateDemo {

    static class Student {
        String name;
        double score;

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public static String getCollegeName() {
            return "Laoma School";
        }


        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public double getScore() {
            return score;
        }
    }
//Predicate示例
    public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
        List<E> retList = new ArrayList<>();
        for (E e : list) {
            if (pred.test(e)) {
                retList.add(e);
            }
        }
        return retList;
    }
//Function示例
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> retList = new ArrayList<>(list.size());
        for (T e : list) {
            retList.add(mapper.apply(e));
        }
        return retList;
    }
//Consumer示例
    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student[] {
                new Student("zhangsan", 89d),
                new Student("lisi", 89d),
                new Student("wangwu", 98d) });

        students = filter(students, t -> t.getScore() > 90);

        for (Student student : students) {
            System.out.println(student.getScore());
        }
        //将学生名称转换为大写的代码可以为：
        students = map(students, t -> new Student(t.getName().toUpperCase(), t.getScore()));
        //根据学生列表返回名称列表的代码可以为：
        List<String> names = map(students, t -> t.getName());
        for (Student student : students) {
            System.out.println(student.getName());
        }

        foreach(students, t -> t.setName(t.getName().toUpperCase()));
        for (Student student : students) {
            System.out.println(student.getName());
        }

        Supplier<String> s = Student::getCollegeName;
        System.out.println(s.get());
        System.out.println();

        Function<Student, String> f = Student::getName;
        System.out.println(f);
    }



}
