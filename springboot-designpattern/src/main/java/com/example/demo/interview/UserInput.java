package com.example.demo.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jiaozhiguang on 2018/1/30.
 */
public class UserInput {

    public static void main(String[] args) throws Exception{

        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        for (int i = 0; i < 20; i++) {
            System.out.println("Enter "+ i +" value:" );
            str = br.readLine();
            stack.push(str);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println("your value is :"+sb);

    }


    public List<A> twentyA() {
        List<A> list = new ArrayList<>();
        A a = new A();
        for (int i = 0; i < 20; i++) {
            list.add(a);
        }
        return list;
    }



    class A {

    }


}
