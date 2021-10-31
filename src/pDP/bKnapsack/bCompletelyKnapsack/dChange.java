package pDP.bKnapsack.bCompletelyKnapsack;

/**
 * 518. 零钱兑换 II
 * todo 在上一题 322. 零钱兑换 中，求的是「取得特定价值所需要的最小物品个数」。对于本题，我们求的是「取得特定价值的方案数量」。
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。
 * 假设每一种面额的硬币有无限个。
 *
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class dChange {

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486586&idx=1&sn=da57c4d7d39bcbd2e16c2cc4e21b2361&chksm=fd9ca765caeb2e73c8fab98ada138d429e0fba35e8af83489cbb4c7a5b6e1e68c1ec341f1cd8&token=536156957&lang=zh_CN&scene=21#wechat_redirect



    // https://mp.weixin.qq.com/s/zGJZpsGVMlk-Vc2PEY4RPw
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i-1] >= 0)
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[n][amount];
    }

}
