package com.example.demo.algorithm;

import java.util.Stack;

public class TwoStackImplQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackImplQueue queue = new TwoStackImplQueue();
        queue.push(1);
        queue.push(6);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(9);
        System.out.println(queue.pop());
        queue.push(7);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());


    }
}