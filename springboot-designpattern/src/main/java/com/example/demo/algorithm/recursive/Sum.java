package com.example.demo.algorithm.recursive;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/16.
 */
public class Sum {

    public static void main(String[] args) {


        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5 ));
        System.out.println(list);
        System.out.println(new Sum().sum(list));
    }

    int sumtmp = 0;
    public int sum(List<Integer> list) {
        if (list.size() == 1) {
            sumtmp +=list.get(0);
        } else {
            sumtmp += list.remove(0);
            sum(list);
        }
        return sumtmp;
    }

}
