package pDP.bCombinate.bKnapsack.bCompletelyKnapsack;

/**
 * 完全背包
 * todo 其实就是在 0-1 背包问题的基础上，增加了每件物品可以选择多次的特点（在容量允许的情况下）。
 * 有N种物品和一个容量为C的背包，每种物品都有无限件。
 * 第i件物品的体积是v[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 其实就是在 0-1 背包问题的基础上，增加了每件物品可以选择多次的特点（在容量允许的情况下）。
 *
 * 示例 1：
 * 输入: N = 2, C = 5, v = [1,2], w = [1,2]
 * 输出: 5
 * 解释: 选一件物品 1，再选两件物品 2，可使价值最大。
 */
public class aCompletelyKnapsack {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486107&idx=1&sn=e5fa523008fc5588737b7ed801caf4c3&chksm=fd9ca184caeb28926959c0987208a3932ed9c965267ed366b5b82a6fc16d42f1ff40c29db5f1&token=990510480&lang=zh_CN&scene=21#wechat_redirect
    public static int maxValue(int N, int C, int[] v, int[] w) {

        int[][] dp = new int[N][C + 1];

        // 先预处理第一件物品
        for (int j = 0; j <= C; j++) {
            // 显然当只有一件物品的时候，在容量允许的情况下，能选多少件就选多少件
            int maxK = j / v[0];
            dp[0][j] = maxK * w[0];
        }

        // 处理剩余物品
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                int n = dp[i - 1][j];
                // 考虑第 i 件物品的情况
                int y = 0;
                for (int k = 1 ;; k++) {
                    if (j < v[i] * k) {
                        break;
                    }
                    y = Math.max(y, dp[i - 1][j - k * v[i]] + k * w[i]);
                }
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N - 1][C];
    }

}
