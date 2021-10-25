package dSort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 */
public class jKthLargest {

    // https://mp.weixin.qq.com/s/zVon8BE7l80-RT5bWdKCxA
    //         queue = new PriorityQueue<>(k, (a,b)->Integer.compare(a,b));


    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>((o1, o2) -> o1-o2);

        /**
         * PriorityQueue(int initialCapacity,
         *                          Comparator<? super E> comparator)
         */
        PriorityQueue<Integer> maxHeap1=new PriorityQueue<Integer>(Integer.MAX_VALUE, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


    }

}
