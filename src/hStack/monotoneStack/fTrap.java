package hStack.monotoneStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 双指针求接雨水问题
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * todo 数组遍历两次。改写遍历一次，可以使用双指针、辅助结构-单调栈。
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 *     输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 *     输出: 6
 */
public class fTrap {


    public static void main(String[] args) {

    }

    /**
     * todo 单调栈解法
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }


    //////////////////////// 双指针
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487509&idx=1&sn=77cae8937a2fc47ab927a169ea7cc6bd&chksm=fb418335cc360a235e63d42f5707ddc9487e552206973ce56ea772b4f6203ba7facfa7236c09&scene=21#wechat_redirect



}
