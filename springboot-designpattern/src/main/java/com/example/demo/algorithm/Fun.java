package com.example.demo.algorithm;

/**
 * Created by jiaozhiguang on 2017/10/17.
 */
public class Fun {

    //给定有序查找表array 二分查找给定的值data
    //查找成功返回下标 查找失败返回-1
    public static int binSearch(int[] array, int data) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            if(data == array[mid]) {
                return mid;
            } else if (data < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static void swapTwo(int a, int b) {

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println(a + " " + b);
    }

    //斐波那契数列 递归实现
    //F（0）=0，
    //F（1）=1
    //F（n）=F(n-1)+F(n-2)
    static long funFib(long index) {
        if(index == 0 ) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return funFib(index - 1) + funFib(index - 2);
        }
    }

    static long fubFib2(long index) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;

        if (index == 0) {
            return f0;
        } else if (index == 1) {
            return f1;
        } else if(index == 2) {
            return f2;
        }

        for(int i=3; i < index; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }

    public static void main(String[] args) {
        Fun.swapTwo(1, 2);
    }

}

