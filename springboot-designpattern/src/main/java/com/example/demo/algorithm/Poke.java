package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jiaozhiguang on 2017/10/30.
 * 洗牌的本质 打乱牌的顺序
 * 程序 = 数据结构 + 算法
 *  操作对象：
 */
public class Poke {

    public static void main(String[] args) {
        ArrayList<String> nums = new ArrayList<String>();
        nums.add("E");
        nums.add("G");
        nums.add("F");
        Collections.sort(nums);
        for(String tmp : nums){
            System.out.print(tmp);
        }
    }

}
