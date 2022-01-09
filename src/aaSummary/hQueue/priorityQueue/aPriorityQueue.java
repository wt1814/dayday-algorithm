package aaSummary.hQueue.priorityQueue;

import java.util.PriorityQueue;

/**
 * 优先级队列
 */
public class aPriorityQueue {


    public static void main(String[] args) {

        /**
         * 增add；删poll； 查peek
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.intValue() - o2.intValue());
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());  // todo peek：查询队顶元素
        System.out.println(priorityQueue.poll());  // todo poll：删除一个元素，并返回删除的元素
        System.out.println(priorityQueue.peek());


    }

}
