package com.example.demo.algorithm;

import java.util.*;

/**
 * Created by jiaozhiguang on 2017/10/24.
 *
 * 可以使用两个堆，一个最大堆，一个最小堆，思路如下：

 假设当前的中位数为m，最大堆维护的是<=m的元素，最小堆维护的是>=m的元素，但两个堆都不包含m。
 当新的元素到达时，比如为e，将e与m进行比较，若e<=m，则将其加入到最大堆中，否则将其加入到最小堆中。
 第二步后，如果此时最小堆和最大堆的元素个数的差值>=2 ，则将m加入到元素个数少的堆中，然后从元素个数多的堆将根节点移除并赋值给m。
 */
public class Median<E> {

    private PriorityQueue<E> minP; //
    private PriorityQueue<E> maxP; //
    private E m;

    public Median() {
        this.minP = new PriorityQueue<>();
        this.maxP = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private int compare(E e, E m) {
        Comparable<? super E> comp = (Comparable<? super E>)e;
        return comp.compareTo(m);
    }

    public void add(E e) {
        if (m == null) {
            m = e;
            return;
        }

        if (compare(e, m) <= 0) {
            maxP.add(e);
        } else {
            minP.add(e);
        }

        if (minP.size() - maxP.size() >= 2) {
            //最小堆元素个数多，即大于中值的数多
            //将m加入到最大堆中，然后将最小堆中的根移除赋给m
            maxP.add(m);
            this.m = minP.poll();
        } else {
            minP.add(e);
            this.m = maxP.poll();
        }
    }

    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public E getM() {
        return m;
    }

    public static void main(String[] args) {
        Median<Integer> median = new Median<>();
        List<Integer> list = Arrays.asList(new Integer[]{ 34, 90, 67, 45, 1, 4, 5, 6, 7, 9, 10});

        median.addAll(list);
        System.out.println(median.getM());
    }

}
