package com.example.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/11.
 */
public class SelctSort {

    public static void main(String[] args) {

        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(2, 3, 4, 5, 9, 8, 7));
        System.out.println(ints);
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < ints.size(); ) {
            int location = max(ints);
            integers.add(ints.get(location));
            ints.remove(location);
        }

        System.out.println(integers);

//        int max = 0;
//        int location = 0;
//        for (int i = ints.size() - 1; i > 0  ; i--) {
//            if (max < ints.get(i)) {
//                max = ints.get(i);
//                location = i;
//            }
//        }
//        System.out.println(max);
//        System.out.println(location);
    }

    public static int max(List<Integer> ints) {
        int max = 0;
        int location = 0;
        for (int i = ints.size() - 1; i > 0  ; i--) {
            if (max < ints.get(i)) {
                max = ints.get(i);
                location = i;
            }
        }
        return location;
    }

}
