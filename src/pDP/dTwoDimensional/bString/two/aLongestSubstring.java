package pDP.dTwoDimensional.bString.two;

/**
 * 牛客题霸第127题. 两个字符串的最长公共子串
 */
public class aLongestSubstring {

    public static void main(String[] argv) {
        String a = "M948e9Kb5KJt80";
        String b = "uD948ez0htzd5YF9J1";
        System.out.println(getLCSLength(a,b));
    }

    // https://www.cnblogs.com/fanguangdexiaoyuer/p/11281179.html
    // https://mp.weixin.qq.com/s/o6jXoYMm8QvWiJrP8Akc8w
    /**
     * 最长公共子串
     * @param s
     * @param t
     * @return
     */
    public static int getLCSLength(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int result = 0;
        // todo 第一个字符串公共子串的最后一个坐标
        int endIndex = 0;

        int sLength = s.length();
        int tLength = t.length();
        // dp数组
        int[][] dp = new int[sLength][tLength];
        // base case，二维数组默认值为0
        dp[0][0] = 0;

        for (int i = 0; i < sLength; i++) {
            for (int k = 0; k < tLength; k++) {

                if (s.charAt(i) == t.charAt(k)) {
                    if (i == 0 || k == 0) {   //todo 第0行或第0列的值
                        dp[i][k] = 1;
                    } else {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }

                    if (dp[i][k] > result){   //todo 更新尾标条件
                        result = Math.max(dp[i][k], result);
                        endIndex = i; //todo 更新尾标
                    }

                    System.out.println("result is "+ result+" endIndex is "+endIndex);
                } else {
                    dp[i][k] = 0;
                }

            }
        }
        System.out.println("最长公共子串，第一个字符串的尾标： "+endIndex);
        return result;
    }


}
