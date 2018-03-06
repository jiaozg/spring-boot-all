package com.example.demo.leecode.simple;

/**

 Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Tags:** Two Pointers, String


 */
public class StrStr {

    public static void main(String[] args) {

        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));

    }

    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return needle.length();
        } else {
            return -1;
        }
    }

}
