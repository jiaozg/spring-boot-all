package com.example.demo.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2018/1/22.
 * 打印出所有的”水仙花数”，所谓”水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
 * 例如:153是一个”水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方
 *
 * 利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 */
public class ShuiXianHua {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i <= 999; i++) {
            if (isShuiXian(i)) {
                list.add(i);
            }
        }
        System.out.println(list);

    }

    public static boolean isShuiXian(int n) {
        int b = n / 100;
        int s = (n % 100)  / 10;
        int g = (n % 10);

        int sum = (int) (Math.pow(b, 3) + Math.pow(s, 3) + Math.pow(g, 3));
        if (sum == n) {
            return true;
        }
        return false;
    }

}
