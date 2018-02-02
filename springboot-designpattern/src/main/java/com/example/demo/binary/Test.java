package com.example.demo.binary;

/**
 * Created by jiaozhiguang on 2018/1/5.
 *
 * 二进制 八进制 十六进制 十进制
 * x小数
 * 负数 （反码 补码）先取反 再加1
 *  反码 - 负数的反码为对该数的原码除符号位外各位取反[每一位取反(除符号位)]
 *  补码 - 正数的补码与原码相同，负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1.
 *0B
 * 0
 * 0X
 * 取值范围
 * */
public class Test {

    public static void main(String[] args) {

        byte b = 127;
        b += 1;
        System.out.println(b);

        //0000 0000 1000 0001
        //0111 1110
        //+1
        //强制转换会舍弃高位

         int e = 129;
         byte f = (byte)129;
        System.out.println(f);

    for(int i=-2; i<3; i++) {
            System.out.println( Integer.toBinaryString(i));
        }

    }

}


