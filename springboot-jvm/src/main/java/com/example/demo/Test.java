package com.example.demo;

/**
 * Created by jiaozhiguang on 2017/9/19.
 */
public class Test {

    public static void main(String[] args) {
        int[] intAttr = {233, 44, 55, 789, -987};

        int temp = intAttr[0];

        for(int x =1; x < intAttr.length; x++) {
            if (intAttr[x] > temp)
                temp = intAttr[x];
        }

        System.out.println(temp);
    }

}
