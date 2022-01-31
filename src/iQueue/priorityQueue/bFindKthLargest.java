package iQueue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class bFindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    /**
     * todo 优先级队列
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>();
        for (int num:nums){
            queue.add(num);
            // 当queue的大小大于k，每次弹出堆顶的最小元素；
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    // 基于堆排序的选择方法
    // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/

    // 基于快速排序的选择方法
    // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/

}
