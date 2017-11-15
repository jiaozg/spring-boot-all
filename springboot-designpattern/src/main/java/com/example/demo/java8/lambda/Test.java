package com.example.demo.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/11/11.
 */
public class Test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia" );
        System.out.println(names);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(names);

        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println(names);
    }

}
