package com.example.demo.algorithm.sort;

/**
 * Created by jiaozhiguang on 2017/10/17.
 */
public class InsertSort {

    static void bubbleSort(int[] array) {

    }

    static int [] inserSort(int[] ints) {
        for (int i = 1; i < ints.length ; i++) {
            if (ints[i] < ints[i - 1]) {
                for(int j = i; j > 0; j--) {
                    if (ints[j] < ints[j - 1]) {
                        int temp = ints[j];
                        ints[j] = ints[j - 1];
                        ints[j - 1] = temp;
                    }
                }
            }
        }
        return ints;
    }

    static void printInts(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

//    static int[] inserSort(int)
    public static void main(String[] args) {


        int[] ints = {2,3,4,5,9,9,8,0,8,7};
        System.out.println("before sort");
        printInts(ints);
        System.out.println();

        ints = inserSort(ints);

//        for (int i = 1; i < ints.length ; i++) {
//            if (ints[i] < ints[i - 1]) {
//                for(int j=0; j<i;j++) {
//                    if (ints[j] > ints[i]) {
//                        int min = ints[i];
//                        for(int k = i; k>j; k--) {
//                            ints[k] = ints[k - 1];
//                        }
//                        ints[j] = min;
//                    }
//                    break;
//                }
//            }
//        }
        printInts(ints);
    }




}
