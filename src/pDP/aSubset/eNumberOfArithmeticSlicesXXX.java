package pDP.aSubset;

/**
 * 413. 等差数列划分
 * todo 结果数组中值连续，可用滑动窗口
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


    public static void main(String[] args) {

    }


    // todo 滑动窗口、动态规划（Java）
    // https://leetcode-cn.com/problems/arithmetic-slices/solution/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/
    //  https://mp.weixin.qq.com/s/lVONbve_on-HY3lKAcgfyg
    /**
     *
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        // dp[i] 表示以：nums[i] 结尾的、且长度大于等于 3 的连续等差数列的个数
        int[] dp = new int[len];
        int res = 0;
        // 从下标 2 开始，才有可能构成长度至少大于等于 3 的等差数列
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1; // 如果 nums[i] 能够接在 nums[i - 1] 之后形成一个长度更长的（在原数组上连续的）等差数列，那么 dp[i] = dp[i - 1] + 1 。
                res += dp[i];
            }
        }
        return res;
    }

}
