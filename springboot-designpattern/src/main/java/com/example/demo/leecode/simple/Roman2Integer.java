package com.example.demo.leecode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 题意是罗马数字转整型数，范围从 1 到 3999，查看下百度百科的罗马数字介绍如下：

 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；

 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；

 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9。

 那么我们可以利用 map 来完成罗马数字的 7 个数字符号：I、V、X、L、C、D、M 和整数的映射关系，然后根据上面的解释来模拟完成即可。
 */
public class Roman2Integer {

    public static void main(String[] args) {

        String  str = "XII";
        System.out.println(str.length());

        System.out.println(roman2int(str));
        System.out.println(roman2int("IX"));

    }

    public static int roman2int(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = roman.length();
        int sum = map.get(roman.charAt(len - 1));

        for (int i = len - 2; i >= 0; --i) {
            if (map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))) {
                sum -= map.get(roman.charAt(i));
            } else {
                sum += map.get(roman.charAt(i));
            }
            
        }
        return sum;

    }

}
