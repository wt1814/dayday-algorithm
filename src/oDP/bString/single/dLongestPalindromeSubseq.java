package oDP.bString.single;

/**
 *
 * 最长回文子序列
 * todo 是子序列，非子串
 * 输入：s = "bbbab" 输出：4 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 输入：s = "cbbd" 输出：2 解释：一个可能的最长回文子序列为 "bb" 。
 */
public class dLongestPalindromeSubseq {

    // https://mp.weixin.qq.com/s/_YznW0t4z-_bzkBGQK6jpQ

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int[][] dp = new int[n][n];

        // 先求长度为1的子序列，再求长度为2的，依次递增
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


}
