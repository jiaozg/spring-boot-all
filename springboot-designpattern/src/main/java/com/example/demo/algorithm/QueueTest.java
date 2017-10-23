package com.example.demo.algorithm;

import java.util.*;

/**
 * Created by jiaozhiguang on 2017/10/23.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(10);
        queue.add(22);

        queue.addAll(Arrays.asList(new Integer[]{11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13}));
        Queue<Integer> pq = new PriorityQueue<>(11, Collections.reverseOrder());
        while (queue.peek() != null) {
            pq.add(queue.peek());
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
        while (pq.peek() != null) {
            System.out.print(pq.poll() + " ");
        }


        Queue<Task> tasks = new PriorityQueue<Task>(11, taskComparator);
        tasks.offer(new Task(20, "写日记"));
        tasks.offer(new Task(10, "看电视"));
        tasks.offer(new Task(100, "写代码"));

        Task task = tasks.poll();

        System.out.println();
        while(task!=null){
            System.out.print("处理任务: "+task.getName()
                    +"，优先级:"+task.getPriority()+"\n");
            task = tasks.poll();
        }

    }

    static class Task {
        int priority;
        String name;

        public Task(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        public int getPriority() {
            return priority;
        }

        public String getName() {
            return name;
        }
    }

    private static Comparator<Task> taskComparator = new Comparator<Task>() {

        @Override
        public int compare(Task o1, Task o2) {
            if(o1.getPriority()>o2.getPriority()){
                return -1;
            }else if(o1.getPriority()<o2.getPriority()){
                return 1;
            }
            return 0;
        }
    };


}
