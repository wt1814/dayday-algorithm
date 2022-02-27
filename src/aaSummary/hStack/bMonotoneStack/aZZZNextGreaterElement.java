package aaSummary.hStack.bMonotoneStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 519 单调栈解下一个更大元素 I
 * todo 单调队列 + List/HashMap(记录)
 * 给你两个没有重复元素的数组nums1和nums2，其中nums1是nums2 的子集。
 * 请你找出nums1中每个元素在nums2中的下一个比其大的值。
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出-1。
 *
 * 示例 1:
 *     输入:nums1=[4,1,2],nums2=[1,3,4,2].
 *     输出:[-1,3,-1]
 *     解释:
 *         对于num1中的数字4 ，你无法在第二个数组中找到下一个更大的数字，因此输出-1。
 *         对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3 。
 *         对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出-1 。
 */
public class aZZZNextGreaterElement {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/kyqZpixS9dZl2L4aSHpggQ
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247490238&idx=1&sn=436de0fa6cd0e3481e429e8402b73450&chksm=fb41899ecc36008808080bbb802501cd976dd94136f30a3a8f05d5302f269b2a4dcbca122a71&scene=21#wechat_redirect
    /**
     * 首先遍历nums2的所有元素，遍历的时候判断栈是否为空：
     * 一，如果栈为空，就把遍历的元素加入到栈中。
     * 二，如果栈不为空，查看栈顶元素是否小于这个遍历的元素：
     * todo 出栈并记录 1，如果小于，说明栈顶元素遇到右边第一个比他大的值，然后栈顶元素出栈，记录下这个值。如果栈还不为空，继续判断……
     * todo 2，如果不小于，把当前遍历的元素加入到栈中。
     * 上面关键一点是怎么记录右边第一个比他大的，可以使用Map。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //todo map中的key是数组中元素的值，value是这个值遇到的右边第一个比它大的值
        Map<Integer, Integer> map = new HashMap<>();
        //单调栈，从栈顶到栈底是递增的
        Stack<Integer> stack = new Stack<>();


        //遍历nums2的所有元素
        // todo 先比较，再入栈
        for (int num : nums2) {
            //todo 如果栈顶元素小于num，说明栈顶元素遇到了右边第一个比它大的值，然后栈顶元素出栈，
            // 记录下这个值。
            while (!stack.empty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            //当前元素入栈
            stack.push(num);
        }

        //遍历nums1的所有元素，然后在map中查找，如果没有查找到，
        //说明没有遇到右边比它大的值，默认给-1。
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }


        return res;

    }

}
