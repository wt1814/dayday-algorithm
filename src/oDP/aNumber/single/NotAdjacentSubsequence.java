package oDP.aNumber.single;

/**
 * 不相邻最大子序列和
 */
public class NotAdjacentSubsequence {

    /**
     * 状态转移表达式：
     * (1)对于当前的元素arr[i]，如果取，那么dp[i] = dp[i-2] + arr[i]
     * (2)如果不取，那么dp[i] = dp[i-1]
     *
     * @param n
     * @param array
     * @return
     */
    public long subsequence (int n, int[] array) {
        // write code here
        //todo n+1，一维数组长度加1，设置哑节点
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = array[0];

        for (int i = 2; i <= n; i++) {

            dp[i] = Math.max(dp[i-1],dp[i-2] + array[i-1]);
        }
        return dp[n];
    }

}
