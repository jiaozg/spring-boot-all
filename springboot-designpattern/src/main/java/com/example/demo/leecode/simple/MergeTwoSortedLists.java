package com.example.demo.leecode.simple;

import java.util.*;

/**
 * Created by jiaozhiguang on 2018/1/31.
 *
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 Tags: Linked List
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1, 2, 4));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(1, 3, 4));
        System.out.println(mergeTwoLists(l1, l2));

        List<User> users = new ArrayList<>();
        users.add(new User("jiao", 11));
        users.add(new User("jiao", 10));
        users.add(new User("jiao", 12));

        for (User user : users) {
            System.out.println(user.getAge());
        }

        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (User user : users) {
            System.out.println(user.getAge());
        }

    }

    public static List<Integer> mergeTwoLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        List<Integer> list = new LinkedList<>();
        for (Integer i : l1) {
            list.add(i);
        }
        for (Integer i : l2) {
            list.add(i);
        }

        Collections.sort(list);
        return list;
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }



}
