package com.example.demo.jvm;

/**
 * Created by jiaozhiguang on 2017/9/29.
 */
public class OomStack {

    private int stackLength = 1;

    private void diGui() {
        stackLength ++;
        diGui();
    }

    public static void main(String[] args) {
        System.out.println("Stack");
        OomStack oomStack = new OomStack();
        oomStack.diGui();
    }

}
