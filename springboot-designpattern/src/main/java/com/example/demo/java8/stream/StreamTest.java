package com.example.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/17.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2,1,5,4,3));
        list.stream().sorted().forEach(System.out::println);

    }

}
