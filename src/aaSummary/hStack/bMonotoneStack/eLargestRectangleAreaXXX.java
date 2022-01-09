package aaSummary.hStack.bMonotoneStack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形（难）
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class eLargestRectangleAreaXXX {


    public static void main(String[] args) {
        int[] hights = {1,5,6,2,3};
        int i = largestRectangleArea(hights);
        System.out.println(i);
    }

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487176&idx=1&sn=4000143dc6bc30f5a2006cff11c6e15d&chksm=fb419de8cc3614fe9bf589cc37a4961add99bf1752b15cf2d71ea1197234f4c6d8a69c5f1bae&scene=21#wechat_redirect
    /**
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= length; i++) {
            int h = (i == length ? 0 : heights[i]);
            //如果栈是空的，或者当前柱子的高度大于等于栈顶元素所对应柱子的高度,
            //直接把当前元素压栈
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }


    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/



}
