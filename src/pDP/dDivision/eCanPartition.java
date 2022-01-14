package pDP.dDivision;

/**
 * 416. 动态规划解分割等和子集
 * 给定一个正整数数组，求是否可以把这个数组分成和相等的两部分。
 */
public class eCanPartition {

    // https://mp.weixin.qq.com/s/OzdkF30p5BHelCi6inAnNg


    // https://mp.weixin.qq.com/s/cFhAvrK8-kk5BHV5cTTWwg
    public boolean canPartition(int[] nums) {

        //计算数组中所有元素的和
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        //如果sum是奇数，说明数组不可能分成完全相等的两份
        if ((sum & 1) == 1){
            return false;
        }
        //sum除以2
        int target = sum >> 1;
        int length = nums.length;
        int[][] dp = new int[length + 1][target+1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= target; j++) {
                //下面是递推公式
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //判断背包最大是否能存放和为target的元素
        return dp[length][target] == target;

    }

}
