package aTest.day0531;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: LongestPalindrome
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/11/21 5:10 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class LongestPalindrome {


    public static void main(String[] args){
        System.out.println(longestPalindrome("babad"));
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int sLen = s.length();
        int maxLen = 0;
        String ans = "";
        boolean[][] P = new boolean[sLen][sLen];
        // 遍历所有长度
        for (int len = 1; len <= sLen; len++) {
            for (int start = 0; start < sLen; start++) {
                int end = start + len - 1;
                // 下标越界，结束循环
                if (end >=sLen) {
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (P[start][end] && len > maxLen) {
                    maxLen = len;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }
}
