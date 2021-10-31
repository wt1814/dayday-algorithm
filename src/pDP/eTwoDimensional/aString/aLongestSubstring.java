package pDP.eTwoDimensional.aString;

/**
 * 牛客题霸第127题. 两个字符串的最长公共子串
 * 输入：abcde bcd
 * 输出：3
 */
public class aLongestSubstring {

    public static void main(String[] argv) {
        String a = "M948e9Kb5KJt80";
        String b = "uD948ez0htzd5YF9J1";
        System.out.println(getLCSLength(a,b));
    }


    ////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/o6jXoYMm8QvWiJrP8Akc8w
    // 理解： https://www.cnblogs.com/fanguangdexiaoyuer/p/11281179.html
    public String LCS(String str1, String str2) {
        int maxLenth = 0;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                //递推公式，两个字符相等的情况
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[i + 1][j + 1] > maxLenth) {
                        maxLenth = dp[i + 1][j+1];
                        maxLastIndex = i;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[i + 1][j+1] = 0;
                }
            }
        }
        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1);
    }


    ////////////////////////////////////////////////////////////////////////
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
