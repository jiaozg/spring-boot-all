package com.example.demo.leecode.simple;

/**
 题意是判断一个有符号整型数是否是回文，也就是逆序过来的整数和原整数相同，首先负数肯定不是，接下来我们分析一下最普通的解法，就是直接算出他的回文数，然后和给定值比较即可。

 好好思考下是否需要计算整个长度，比如 1234321，其实不然，我们只需要计算一半的长度即可，就是在计算过程中的那个逆序数比不断除 10 的数大就结束计算即可，但是这也带来了另一个问题，比如 10 的倍数的数 10010，它也会返回 true，所以我们需要对 10 的倍数的数再加个判断即可，代码如下所示。
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome1(12321));

    }

    public static boolean isPalinddrome(int x) {
        if(x < 0){ return false;}

        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }

        return x == reverse;

    }


    public static boolean isPalindrome1(int x) {
        if(x < 0 || (x != 0 && x %10 == 0)) return false;

        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x%10;
            x /= 10;
        }

        return x == halfReverseX || halfReverseX /10 == x;
    }
}
