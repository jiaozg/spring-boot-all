package com.example.demo.test;

/**
 * Created by jiaozhiguang on 2017/10/17.
 */
public class Test {

    static int[] arr = new int[10];

    public static void main(String[] args) {
        System.out.println(3*0.1 == 0.3);
        System.out.println(-1>>1);
        System.out.println(-1>>>1);
        System.out.println(2>>1);
        System.out.println(2>>>1);

        System.out.println(arr[1]);

        System.out.println("##########");

        System.out.println(foo(50));

        System.out.println(Integer.toBinaryString(48));
        System.out.println(Integer.toBinaryString(47));

        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(31));

    }

    public static int foo(int x) {
        int count=0;
        while(x>0){
            count++;
            x = x & (x - 1);
        }
        return count;
    }
}
