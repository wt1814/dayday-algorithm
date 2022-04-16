package pDP.bCombinate.bKnapsack.a01Knapsack;

/**
 * 1049. 动态规划解最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *     如果 x == y，那么两块石头都会被完全粉碎；
 *     如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 */
public class bLastStoneWeightIIXXX {

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488868&idx=1&sn=5e54a1d091a8249d3033a28fc299076d&chksm=fd9cbe7bcaeb376d1ee8a753ebc57358e5605fc1a3b51865eb0f758fb3e6e4688e1b0acfa902&scene=178&cur_album_id=1751702161341628417#rd

    // https://mp.weixin.qq.com/s/J_cv0Ut4qb6Cw6GXfKeEGg
    public static int lastStoneWeightII(int[] stones) {

        int length = stones.length;
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        //背包的容量
        int capacity = sum >> 1;
        //dp[i][j]表示前i个石头放进容量为j的背包所能获取的最大重量
        int dp[][] = new int[length + 1][capacity + 1];

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= capacity; j++) {
                //如果背包剩余容量能放下石头stones[i - 1]，取把石头stones[i - 1]放进
                //背包和不放进背包的最大值
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    //背包容量已经放不下石头了
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //sum - dp[length][capacity]是一部分，dp[length][capacity]是另一部分，上面
        //capacity的取值是sum >> 1，往下取整，所以前面的肯定不小于后面的，不需要取绝对值
        return (sum - dp[length][capacity]) - dp[length][capacity];

    }

}
