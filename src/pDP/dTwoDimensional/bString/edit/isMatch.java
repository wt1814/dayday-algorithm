package pDP.dTwoDimensional.bString.edit;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *     '.' 匹配任意单个字符
 *     '*' 匹配零个或多个前面的那一个元素
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class isMatch {



    // https://mp.weixin.qq.com/s/KWR93SbRQxjZdZNGiPxG5A

    public static boolean isMatch(String s, String p) {
        //如果s不为空，p为空，是匹配不成功的，直接返回false
        if (s.length() != 0 && p.length() == 0) {
            return false;
        }

        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        //边界条件的初始化
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
