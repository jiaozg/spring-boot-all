package com.example.demo.interview;

import java.util.Scanner;

/**
 * Created by jiaozhiguang on 2018/1/12.
 */
public class AbcTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char s = str.charAt(0);

        double count = 1, d;
        for (int i = 0; i < str.length(); i++) {
            if (s != str.charAt(i)) {
                s = str.charAt(i);
                count++;
            }
        }

        d=str.length()/count;
        System.out.println(String.format("%.2f", d));
    }


}
