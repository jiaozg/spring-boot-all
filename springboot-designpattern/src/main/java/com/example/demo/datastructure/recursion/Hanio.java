package com.example.demo.datastructure.recursion;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class Hanio {

    public static void main(String[] args) {
        String a = "A";
        String b = "B";
        String c = "C";
        hanio(4, a, b, c);
    }

    static StringBuffer str = new StringBuffer();
    /**
     * //汉诺塔问题
     * @param n 盘子的个数
     * @param x 将要移动盘子柱子
     * @param y 要借用的柱子
     * @param z 要移动到的柱子
     * @return
     */
    public static String hanio(int n, Object a, Object b, Object c) {
        //String str ="";
        if(1 == n)
            str.append(move(a, n, c) + "\n");
        else {
            hanio(n-1, a, c, b);
            str.append(move(a, n, c) + "\n") ;
            hanio(n-1, b, a, c);
        }
        return str.toString();
    }
    private static String move(Object x, int n, Object y) {
        System.out.println("Move  " + n + "  from  " + x + "  to  " + y);
        return "Move  " + n + "  from  " + x + "  to  " + y;
    }

}
