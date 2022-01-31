package aaSummary.iQueue.priorityQueue;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 *     KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 *     int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class dKthLargest {

    // https://mp.weixin.qq.com/s/zVon8BE7l80-RT5bWdKCxA
    int k;
    PriorityQueue<Integer> queue;

    public dKthLargest(int _k, int[] _nums) {
        k = _k;
        queue = new PriorityQueue<>(k, (a,b)->Integer.compare(a,b));
        int n = _nums.length;
        for (int i = 0; i < k && i < n; i++) {
            queue.add(_nums[i]);
        }
        for (int i = k; i < n; i++) {
            add(_nums[i]);
        }
    }

    public int add(int val) {
        int t = !queue.isEmpty() ? queue.peek() : Integer.MIN_VALUE;
        if (val > t || queue.size() < k) {
            if (!queue.isEmpty() && queue.size() >= k) {
                queue.poll();
            }
            queue.add(val);
        }
        return queue.peek();
    }

}
