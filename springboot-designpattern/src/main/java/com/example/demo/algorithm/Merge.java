package com.example.demo.algorithm;

/**
 * Created by jiaozhiguang on 2017/10/24.
 */
public class Merge {

    public static void main(String[] args) {

        String str = "aa";
        long l = 1L;


        System.out.println();

        int [] ints = {1,3,5,7,9};
        int[] ints1 = {2, 4, 6, 8, 10};

        int [] ints2 = new int[ints.length + ints1.length];
        for (int i = 0; i <ints.length ; i++) {
            ints2[i] = ints[i];
        }

        for (int i = 0; i <ints2.length ; i++) {
            System.out.print(ints2[i]);
        }
        System.out.println();

        for (int i = 0; i < ints1.length ; i++) {
            insert(ints2, ints1[i]);
        }

        for (int i = 0; i <ints2.length ; i++) {
            System.out.print(ints2[i]);
        }

    }



    static int[] insert(int[] ints, int num) {
        for (int i = 0; i <ints.length ; i++) {
            if (ints[i] > num && ints[i] != 0) {
                for(int j = ints.length; j >=i; j--) {
                    if(j >= 2) {
                        ints[j-1] = ints[j - 2];
                    }
                }
                ints[i] = num;
            }
        }
        return ints;
    }

}
