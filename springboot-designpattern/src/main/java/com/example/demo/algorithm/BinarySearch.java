package com.example.demo.algorithm;

/**
 * Created by jiaozhiguang on 2017/11/29.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int [] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int start = 0;
        int end = ints.length -1 ;
        int find = 9;
        int location = -1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(ints[mid] == find) {
                location = mid;
                System.out.println("位置是 int["+ mid + "] = " + ints[mid]);
                break;
            } else if (ints[mid] > find) {
                end = mid - 1 ;
            } else {
                start = mid + 1;
            }
        }
        if (location == -1) {
            System.out.println("没找到");
        }
    }

}
