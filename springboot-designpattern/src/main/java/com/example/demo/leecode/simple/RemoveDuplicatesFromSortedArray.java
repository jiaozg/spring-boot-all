package com.example.demo.leecode.simple;

/**
 Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 Tags: Array, Two Pointers

 题意是让你从一个有序的数组中移除重复的元素，并返回之后数组的长度。我的思路是判断长度小于等于 1 的话直接返回原长度即可，否则的话遍历一遍数组，
 用一个 tail 变量指向尾部，如果后面的元素和前面的元素不同，就让 tail 变量加一，最后返回 tail 即可。

 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};

        int len = removeDuplicates(nums);

        System.out.println(len);
        prt(nums);

    }

    public static int removeDuplicates(int[] nums) {

        prt(nums);

        int len = nums.length;
        if(len == 1) {
            return len;
        }

        int tail = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[tail++] = nums[i];
            }
        }

        return tail;
    }

    public static void prt(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}