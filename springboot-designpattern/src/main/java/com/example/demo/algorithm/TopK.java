package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created by jiaozhiguang on 2017/10/24.
 *
 * 解决方法是使用最小堆维护这K个元素，最小堆中，根即第一个元素永远都是最小的，新来的元素与根比就可以了，如果小于根，则堆不需要变化，
 * 否则用新元素替换根，然后向下调整堆即可，调整的效率为O(log2(K))，这样，总体的效率就是O(N*log2(K))，这个效率非常高，
 * 而且存储成本也很低。

 使用最小堆之后，第K个最大的元素也很容易获得，它就是堆的根。
 */
public class TopK<E> {

    private PriorityQueue<E> pq;
    private int k;

    public TopK(int k) {
        this.k = k;
        pq = new PriorityQueue<>();
    }

    public void addAll(Collection<? extends E> collection) {
        for (E e : collection) {
            add(e);
        }
    }

    public void add(E e) {
        if (pq.size() < k) {
            pq.add(e);
            return;
        }
        Comparable<? super E> head = (Comparable<? super E>) pq.peek();
        if (head.compareTo(e) > 0) {
            //小于TopK中的最小值，不用变
            return;
        }
        //新元素替换掉原来的最小值成为Top K之一。
        pq.poll();
        pq.add(e);
    }

    public <T> T[] toArray(T[] a){
        return pq.toArray(a);
    }

    public E getKth(){
        return pq.peek();
    }

    public static void main(String[] args) {
        TopK<Integer> top5 = new TopK<>(5);
        top5.addAll(Arrays.asList(new Integer[] {100, 1, 2, 5, 6, 7, 34, 9, 3, 4, 5, 8, 23, 21, 90, 1, 0}));

        System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
        System.out.println(top5.getKth());

    }

}
