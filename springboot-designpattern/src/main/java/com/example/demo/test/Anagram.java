package com.example.demo.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiaozhiguang on 2017/10/24.
 */
public class Anagram {

    public static void main(String[] args) {
        String evil = "evil";
        String live = "live";

        System.out.println(isAnagram(evil, live));

    }

    public static boolean isAnagram(String from, String to) {
        Set<Character> set = new HashSet();
        for (int i = 0; i <from.length() ; i++) {
            set.add(from.charAt(i));
        }

        for (int i = 0; i <to.length() ; i++) {
            if (set.add(to.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
