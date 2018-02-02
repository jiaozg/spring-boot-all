package com.example.demo.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jiaozhiguang on 2018/1/31.
 */
public class ListRemoveTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(8);

        System.out.println(list);



        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list);
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }

        System.out.println(list);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(8);


        Iterator<Integer> integers = list.iterator();
        while (integers.hasNext()) {
            Integer integer = integers.next();
            if (integer % 2 == 0) {
                integers.remove();
            }
        }

        System.out.println(list);
    }

}
