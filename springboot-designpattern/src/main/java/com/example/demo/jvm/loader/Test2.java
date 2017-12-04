package com.example.demo.jvm.loader;

/**
 * Created by jiaozhiguang on 2017/9/18.
 */
public class Test2 {
//    static {
//        System.out.println("静态初始化块执行了！");
//    }
    static boolean print(char char1) {
        System.out.println(char1);
        return true;
    }

    public static void main(String[] args) {
        int x = 0;
        for(print('1'); print('2') && (x < 2); print('3')) {
            x++;
            print('4');
        }
    }
}

