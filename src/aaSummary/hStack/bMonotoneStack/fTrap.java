package aaSummary.hStack.bMonotoneStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水问题
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


    ////////////////////////////////////////////// 单调栈解法//////////////////////////////////////////////////////////////////
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


    ////////////////////////////////////////////// 双指针//////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487509&idx=1&sn=77cae8937a2fc47ab927a169ea7cc6bd&chksm=fb418335cc360a235e63d42f5707ddc9487e552206973ce56ea772b4f6203ba7facfa7236c09&scene=21#wechat_redirect

    public int trap1(int[] height) {
        if (height.length <= 2)
            return 0;
        int water = 0;
        int left = 0, right = height.length - 1;
        //最开始的时候确定left和right的边界，这里的left和right是
        //柱子的下标，不是柱子的高度
        while (left < right && height[left] <= height[left + 1])
            left++;
        while (left < right && height[right] <= height[right - 1])
            right--;

        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            //在left和right两根柱子之间计算盛水量
            if (leftValue <= rightValue) {
                //如果左边柱子高度小于等于右边柱子的高度，根据木桶原理，
                // 桶的高度就是左边柱子的高度
                while (left < right && leftValue >= height[++left]) {
                    water += leftValue - height[left];
                }
            } else {
                //如果左边柱子高度大于右边柱子的高度，根据木桶原理，
                // 桶的高度就是右边柱子的高度
                while (left < right && height[--right] <= rightValue) {
                    water += rightValue - height[right];
                }
            }
        }
        return water;
    }


    //////////////////////////////////////双指针优化
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            //确定左边的最高柱子
            leftmax = Math.max(leftmax, height[left]);
            //确定左边的最高柱子
            rightmax = Math.max(rightmax, height[right]);
            //那么桶的高度就是leftmax和rightmax中最小的那个
            if (leftmax < rightmax) {
                //桶的高度是leftmax
                water += (leftmax - height[left++]);
            } else {
                //桶的高度是rightmax
                water += (rightmax - height[right--]);
            }
        }
        return water;
    }



}
