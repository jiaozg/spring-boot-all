package com.example.demo.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiaozhiguang on 2018/1/19.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] ints = new int[] {2,2,3,3,4};

        Set set = new HashSet();
        for (int i = 0; i < ints.length ; i++) {
            if (!set.contains(ints[i])) {
                set.add(ints[i]);
            } else {
                set.remove(ints[i]);
            }
        }
        System.out.println(set);
    }
}
