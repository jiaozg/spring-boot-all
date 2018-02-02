package com.example.demo.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaozhiguang on 2018/1/11.
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println(1 & 1);
        System.out.println(1 & 0);
        System.out.println(0 & 1);
        System.out.println(0 & 0);

        Map map = new HashMap();
        map.put("a", "a");
        map.put("a", "b");

        System.out.println(map.get("a"));

    }

}
