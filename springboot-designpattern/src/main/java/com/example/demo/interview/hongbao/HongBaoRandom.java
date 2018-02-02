package com.example.demo.interview.hongbao;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jiaozhiguang on 2018/1/14.
 */
public class HongBaoRandom {

    public static void main(String[] args) {

        int[] p = divide1(1, 3);
        for (int a : p) {
            System.out.println(a);
        }

        

    }

    public static int[] divide1(double money, int n) {
        int[] persons = new int[n];
        int fen = (int) (money * 100);
        if (fen < n) {
            throw new IllegalArgumentException("金额至少保持没人一分");
        }

//        for (int i = 0; i <n ; i++) {
//            persons[i] = 1;
//        }
        Arrays.fill(persons, 1);
        fen -= n;

        Random random = new Random();
        int i = 0;
        while (fen > 1) {
            int f = random.nextInt(fen);
            persons[i++ % n] += f;
            fen -= f;

        }

        persons[0] += 1;



        return persons;
    }


    public static int[] divide2(double money, int n) {
        int[] persons = new int[n];
        int fen = (int) (money * 100);
        if (fen < n) {
            throw new IllegalArgumentException("金额至少保持没人一分");
        }

        for (int i = 0; i <n ; i++) {
            persons[i] = 1;
        }
        fen -= n;

        Random random = new Random();
        while (fen > 1) {
            int avgfen = fen/n;
            for (int i = 0; i < n; i++) {
                int rand = random.nextInt(avgfen);
                persons[i] = persons[i] + rand;
                fen -= rand;
            }
        }

        persons[0] += 1;

        for (int i = 0; i < n ; i++) {
            System.out.println(persons[i]);
        }

        return persons;
    }

}
