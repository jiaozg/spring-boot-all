package com.example.demo.java8.stream;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jiaozhiguang on 2017/10/8.
 */
public class StreamDemo {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "a", 91));
        students.add(new Student(1, "b", 92));
        students.add(new Student(1, "c", 81));
        students.add(new Student(1, "d", 41));
        students.add(new Student(1, "e", 91));


//        List<Student> above90List = new ArrayList<>();
//        for (Student t : students) {
//            if (t.getScore() > 90) {
//                above90List.add(t);
//            }
//        }

        //filter
        List<Student> above90List = students.stream().filter(t -> t.getScore() > 90).collect(Collectors.toList());


        System.out.println(above90List);

//        List<String> nameList = new ArrayList<>(students.size());
//        for (Student t : students) {
//            nameList.add(t.getName());
//        }

//        List<String> nameList = students.stream().map(Student::getName).collect(Collectors.toList());


//        List<String> nameList = new ArrayList<>();
//        for (Student t : students) {
//            if (t.getScore() > 90) {
//                nameList.add(t.getName());
//            }
//        }

        //map
        List<String> nameList = students.stream().filter(t -> t.getScore()>90).
                map(Student::getName).collect(Collectors.toList());


        System.out.println(nameList);

        //distinct
        List<String> list = Arrays.asList(new String[]{"abc","def","hello","Abc"});
        List<String> retList = list.stream()
                .filter(s->s.length()<=3)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(retList);


        List<Student> list1 = students.stream()
                .filter(t->t.getScore()>90)
                .sorted(Comparator.comparing(Student::getScore)
                        .reversed()
                        .thenComparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println(list1);

        List<Student> list2 = students.stream()
                .sorted(Comparator.comparing(
                        Student::getScore).reversed())
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(list2);

        //peek
        List<String> above90Names = students.stream()
                .filter(t->t.getScore()>90)
                .peek(System.out::println)
                .map(Student::getName)
                .collect(Collectors.toList());

        //mapToLong/mapToInt/mapToDouble
        double sum = students.stream()
                .mapToDouble(Student::getScore)
                .sum();
        System.out.println(sum);

        List<String> lines = Arrays.asList(new String[]{
                "hello abc",
                "老马  编程"
        });
        //floatMap
        List<String> words = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.toList());
        System.out.println(words);

        //max
        Student student = students.stream()
                .max(Comparator.comparing(Student::getScore).reversed())
                .get();

        System.out.println(student);

        long count = students.stream()
                .filter(t->t.getScore()>90)
                .count();
        System.out.println(count);

        boolean allPass = students.stream()
                .allMatch(t->t.getScore()>=60);
        System.out.println(allPass);

        Optional<Student> student1 = students.stream()
                .filter(t->t.getScore()<60)
                .findAny();
        System.out.println(student1);

        students.stream()
                .filter(t->t.getScore()>90)
                .forEach(System.out::println);

        Student[] above90Arr = students.stream()
                .filter(t->t.getScore()>90)
                .toArray(Student[]::new);

        Student topStudent = students.stream().reduce((accu, t) -> {
            if (accu.getScore() >= t.getScore()) {
                return accu;
            } else {
                return t;
            }
        }).get();


        File[] files = new File(".").listFiles();
        Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);

        //输出10个随机数
        Stream.generate(()->Math.random())
                .limit(10)
                .forEach(System.out::println);
        //输出100个递增的奇数
        Stream.iterate(1, t->t+2)
                .limit(100)
                .forEach(System.out::println);

    }
}
