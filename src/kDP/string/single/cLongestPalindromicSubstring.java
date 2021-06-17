package kDP.string.single;

/**
 * 最长回文子串
 */
public class cLongestPalindromicSubstring {


    // https://www.cxyxiaowu.com/2869.html

    // todo bilibili官方视频：https://www.bilibili.com/video/BV1L54y1D7pa
    // todo 题解：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
    // dp[i][j] 表示子串s[i...j]是否为回文子串
    // 状态转移方程： dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
    // 边界条件：j - 1 -(i+1) +1 <2，整理得 j-i <3 ==> j-i+1 <4 ，s[i...j]长度为2或者3时，不用检查子串是否回文
    // 初始化：dp[i][i] =  true
    // 输出：在得到一个状态的值为true的时候，记录起始位置和长度，填表完成以后再截取

    /**
     * dp解最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {  //todo 先从列开始填
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
