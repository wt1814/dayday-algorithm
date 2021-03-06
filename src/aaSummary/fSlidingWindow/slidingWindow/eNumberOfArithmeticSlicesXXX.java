package aaSummary.fSlidingWindow.slidingWindow;

/**
 * 413. 等差数列划分
 * todo 结果数组的值连续，可用滑动窗口
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *     例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 */
public class eNumberOfArithmeticSlicesXXX {

    // todo 滑动窗口、动态规划（Java）
    // https://leetcode-cn.com/problems/arithmetic-slices/solution/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/
    //  https://mp.weixin.qq.com/s/lVONbve_on-HY3lKAcgfyg

    ////////////////////////////// 双指针
    // 滑动窗口 https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488137&idx=1&sn=71e9f2adc320ffd74493c4f3e4b132bf&chksm=fd9cb996caeb30803b3a28b2a4c6f16b05f6cc6209c1e025e32e7ef6578e8e5ed42dc68805af&scene=178&cur_album_id=1748659352518868992#rd
    // https://mp.weixin.qq.com/s/lVONbve_on-HY3lKAcgfyg
    // https://leetcode-cn.com/problems/arithmetic-slices/solution/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/


	
	///////////////////////////////////////////////////////////////////////////////////
	/**
	 * https://leetcode-cn.com/problems/arithmetic-slices/solution/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/
	 * @param nums
	 * @return
	 */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        // 初始化
        int preDiff = nums[1] - nums[0];
        // 当前得到的等差数列的长度，有「差」必有两个元素，因此初始化的时候 L = 2
        int L = 2;
        int res = 0;
        // 从下标 2 开始比较「当前的差」与「上一轮的差」是否相等
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == preDiff) {
                L++;
            } else {
                // 加入结果，然后重置 L 和 preDiff
                res += (L - 1) * (L - 2) / 2;
                L = 2;
                preDiff = diff;
            }
        }

        // 最后还要再计算一下结果
        res += (L - 1) * (L - 2) / 2;
        return res;
    }
	
}
