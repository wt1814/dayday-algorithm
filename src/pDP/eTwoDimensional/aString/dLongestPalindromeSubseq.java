package pDP.eTwoDimensional.aString;

/**
 * 516. 最长回文子序列
 * todo 是子序列，非子串
 * 题目地址： https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 输入：s = "bbbab" 输出：4 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 输入：s = "cbbd" 输出：2 解释：一个可能的最长回文子序列为 "bb" 。
 */
public class dLongestPalindromeSubseq {

    public static void main(String[] args) {

    }

    // todo 理解 https://mp.weixin.qq.com/s/zNai1pzXHeB2tQE6AdOXTA

    ///////////////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/_YznW0t4z-_bzkBGQK6jpQ
    public static int longestPalindromeSubseq3(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int[][] dp = new int[n][n];

        // todo 先求长度为1的子序列，再求长度为2的，依次递增
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

    ///////////////////////////////////////////////////////////////////////////////////

    // todo https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dpzi-dv83q/
    /**
     * 动规五部曲分析如下：
     * 1. 确定dp数组（dp table）以及下标的含义
     * 2. 确定递推公式
     * 3. dp数组如何初始化
     * todo 4. 确定遍历顺序
     * 5. 举例推导dp数组
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // todo https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-3/
    // https://mp.weixin.qq.com/s/FmWvxnlJLIzUYDI23u08Aw
    // https://mp.weixin.qq.com/s/_YznW0t4z-_bzkBGQK6jpQ

    /**
     * todo 动态规划，四要素
     * 1. 状态 f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
     *
     * 2. 转移方程
     * 如果 s 的第 i 个字符和第 j 个字符相同的话
     * f[i][j] = f[i + 1][j - 1] + 2
     * 如果 s 的第 i 个字符和第 j 个字符不同的话
     * f[i][j] = max(f[i + 1][j], f[i][j - 1])
     * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
     *
     * 3. 初始化 f[i][i] = 1 单个字符的最长回文序列是 1
     *
     * 4. 结果 f[0][n - 1]
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq2(String s) {

        int n = s.length();
        int[][] f = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;   // todo i = i 设置为1
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }

        return f[0][n - 1];

    }

}
