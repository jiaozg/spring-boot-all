package com.example.demo.binary;

/**
 * Created by jiaozhiguang on 2018/1/16.
 */
public class LongTest {

    public static void main(String[] args) {

        System.out.println(Long.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println();

        //0111 1111
        //1 + 2 + 4 + 8 + 16 + 32 + 64 = 127
        //1111 1111
        //
        byte b = 124;
        short s = 32767;
        int i = 2147483647; //0111 1111,1111 1111, 1111 1111, 1111 1111
        long l = 2147483648L;

        long result = b+i; //+s+l;
        System.out.println(result);
        result = b+i+s;//+l;
        System.out.println(result);
        result = b+i+s+l;
        System.out.println(result);
        System.out.println("累和："+result);
    }

}
