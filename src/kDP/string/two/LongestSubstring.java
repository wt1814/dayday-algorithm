package kDP.string.two;

/**
 * 两个字符串的最长公共子串
 */
public class LongestSubstring {


    public static void main(String[] argv) {
        String a = "1AB2345CD";
        String b = "12345EF";
        System.out.println(getLCSEndIndex(a,b));
    }


    /**
     * 基于最长公共子串的长度改造
     * @param s
     * @param t
     * @return
     */
    public static int getLCSEndIndex(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        /**
         * dp数组
         */
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength][tLength];

        // base case，二维数组默认值为0
        dp[0][0] = 0;

        int result = 0;
        // todo 第一个字符串公共子串的最后一个坐标
        int endIndex = 0;

        for (int i = 0; i < sLength; i++) {
            for (int k = 0; k < tLength; k++) {

                if (s.charAt(i) == t.charAt(k)) {
                    if (i == 0 || k == 0) {
                        dp[i][k] = 1;
                    } else {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }
                    result = Math.max(dp[i][k], result);
                    endIndex = i;
                } else {
                    dp[i][k] = 0;
                }

            }
        }
        return endIndex;
    }

}
