package hQueue.priorityQueue;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * 优先级队列
 */
public class aPriorityQueue {


    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.intValue() - o2.intValue());
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());


    }

}
