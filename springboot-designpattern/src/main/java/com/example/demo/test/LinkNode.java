package com.example.demo.test;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/4.
 */

@Data
public class LinkNode {

    private int no;
    private String name;
    private String gender;
    private float score;

    private LinkNode next;

    LinkNode(int no, String name, String gender, float score, LinkNode next) {
        this.no = no;
        this.name = name;
        this.gender = gender;
        this.score = score;
        this.next = next;
    }

    public static void printAll(LinkNode first) {
        if (first != null) {
            System.out.println(first);
            printAll(first.next);
//            while (first.next != null) {
//                printAll(first.next);
//            }
        }

    }



    public static void main(String[] args) {
        LinkNode four = new LinkNode(4, "Annie", "M", 62f, null);
        LinkNode three = new LinkNode(3, "Candy", "F", 79f, four);
        LinkNode two = new LinkNode(2, "Ben", "M", 82f, three);
        LinkNode one = new LinkNode(1, "Annie", "M", 92f, two);

        List<LinkNode> list = new LinkedList<>();


        printAll(one);

    }
}
