package com.example.demo.algorithm;

/**
 * Created by jiaozhiguang on 2017/10/21.
 */
public class Search {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 5, 6, 7, 8, 9};
        int s = 0;
        int e = ints.length - 1;
        int m = (s+e)/2;

        int f = 8;
        int location = 0;
        System.out.println(location);

        while(s<=e){
            if (ints[m] == f) {
                location = m;
                break;
            } else if(ints[m] > f) {
                e = m -1;
            } else {
                s = m + 1;
            }
            m = (s+e)/2;
        }
        System.out.println(location);

    }

}
