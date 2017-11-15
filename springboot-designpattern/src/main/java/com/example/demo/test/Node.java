package com.example.demo.test;

import lombok.Data;

/**
 * Created by jiaozhiguang on 2017/11/14.
 */
@Data
public class Node {

    private String name;
    private Node parent;

    public Node() {
    }

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    public static void getAllParent(Node node) {
        System.out.println(node.getName());
        if (node.getParent() != null) {
            getAllParent(node.getParent());
        }
    }

    public static void main(String[] args) {
        Node root = new Node("root", null);
        Node child1 = new Node("child1", root);
        Node child12 = new Node("child12", child1);

        getAllParent(child12);
    }

}
