package pDP.dTwoDimensional.aString;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *     '.' 匹配任意单个字符
 *     '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 示例 1：
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class fIsMatch {

    // https://mp.weixin.qq.com/s/KWR93SbRQxjZdZNGiPxG5A
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484130&idx=1&sn=af3517194634dde1652ec72eb5ea9ff2&chksm=fd9ca9fdcaeb20eb1fd7509e3adf8fee6f75d77b8afbd30067ac11a56bd77b5066b0f164eb49&scene=178&cur_album_id=1748759632187047943#rd

    public static boolean isMatch(String s, String p) {
        //如果s不为空，p为空，是匹配不成功的，直接返回false
        if (s.length() != 0 && p.length() == 0) {
            return false;
        }

        int slen = s.length(), plen = p.length();
        // 状态定义：f(i,j) 代表考虑 s 中以 i 为结尾的子串和 p 中的 j 为结尾的子串是否匹配。即最终我们要求的结果为 f[n][m] 。
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        //边界条件的初始化
        dp[0][0] = true;
        for (int j = 1; j <= plen && dp[0][j - 1]; j++){
            dp[0][j] = p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char si = s.charAt(i - 1), pj = p.charAt(j - 1);
                //下面是动态规划的状态转移方程
                if (si == pj || pj == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pj == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[slen][plen];
    }

}
