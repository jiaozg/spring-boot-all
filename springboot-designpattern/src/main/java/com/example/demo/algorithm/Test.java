package com.example.demo.algorithm;

/**
 * Created by jiaozhiguang on 2017/10/19.
 */
public class Test {

    public static void main(String[] args) {

        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.toString());
        }

        //5! 1*2*3*4*5
        int n = 5;
        int num = 1;
        for(int i=1; i<=n; i++) {
            num = num*i;
        }
        System.out.println(num);

        System.out.println(numn(5));

        n = 40;
        long numl = 1;
        for(int i=1; i<=n; i++) {
            numl = numl*i;
        }
        System.out.println(numl);

        //大数字运算  存储到数组里

        n = 50;
        int[] ints = new int[100];
        ints[ints.length - 1] = 1;

        for (int i = 1; i <n ; i++) {
            ints = bignum(ints, i);
        }



        System.out.println("#########");
        for (int i=0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

        System.out.println();

        System.out.println(732*16);

    }

    static int[] bignum(int[] ints, int num) {
        for(int i=0; i < ints.length; i++) {
            ints[i] *= num;
        }

        for(int j = ints.length -1; j>0; j--) {
            ints[j - 1] += ints[j] / 10;
            ints[j] = ints[j] % 10;
        }
        return ints;
    }

    public static int numn(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * numn(n - 1);
        }
    }

}
