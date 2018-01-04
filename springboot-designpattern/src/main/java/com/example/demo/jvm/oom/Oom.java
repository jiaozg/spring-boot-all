package com.example.demo.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/9/29.
 */
public class Oom {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello OOM");

//        String [] string = new String[1000000000];

        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 10000 == 0 ) {
                System.out.println("i = " + i);
            }
            list.add(new Object());
        }
    }

}
