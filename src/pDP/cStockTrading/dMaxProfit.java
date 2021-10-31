package pDP.cStockTrading;

/**
 * 123. 买卖股票的最佳时机 III
 * todo 最多可以完成 两笔 交易
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
public class dMaxProfit {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/klTOZGvoDDBvnITksSbQaw
    public static int maxProfit(int[] prices) {
        // dp[i][j]表示在j天结束之后最多交易i次所能获得的最大利润。
        int[][] dp = new int[3][prices.length];
        //k是交易的次数，从1开始，如果是0表示没有交易，这个不需要计算
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < prices.length; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    int max = 0;
                    if (k == 0) {
                        //递推公式的边界条件判断，k等于0表示在第一天买入，第j天卖出，这种情况下我们最多
                        //进行一次股票交易，所以不需要dp[i - 1][k - 1]。
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k]);
                    } else {
                        //递推公式
                        //要么第j天不进行任何操作，要么第j天卖出一支股票。如果卖出股票我们需要找到卖出
                        //股票的最大利润（注意这里k不一定是买入股票最低价的那天，这里的最大利润还需要
                        //包含前面交易的利润，所以是prices[j] - prices[k] + dp[i - 1][k - 1]）
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k] + dp[i - 1][k - 1]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[2][prices.length - 1];
    }

}
