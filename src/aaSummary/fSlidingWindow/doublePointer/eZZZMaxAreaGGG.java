package aaSummary.fSlidingWindow.doublePointer;

/**
 * 11. 盛最多水的容器
 * todo 根据题目，找规律
 * leetcode： https://leetcode-cn.com/problems/container-with-most-water/
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class eZZZMaxAreaGGG {

    public static void main(String[] args) {

        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(arr);
        System.out.println(i);

    }


    // 理解： https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484229&idx=2&sn=e3d730a608987d3c764f17578ab4e8af&chksm=fd9ca85acaeb214cb2ab0e66b3ee5f8b20a5159aef56e23b92669669b039187836d53ce48bb7&scene=178&cur_album_id=1748659352518868992#rd
    /**
     * 在初始时，左右指针分别指向数组的左右两端
     * todo 此时需要移动一个指针。移动哪一个呢？直觉告诉我们，
     * todo todo todo 应该移动对应数字较小的那个指针（即此时的左指针）。
     * 这是因为，由于容纳的水量是由两个指针指向的数字中较小值∗指针之间的距离
     */
    public static int maxArea(int[] height) {

        int l = 0, r = height.length - 1;  // 定义左右指针
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;

    }


}
