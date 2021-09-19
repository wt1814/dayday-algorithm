package oDP.bString.two;

/**
 * 最长公共子序列
 * todo dp数组下标
 */
public class bLongestCommonSequenceOfOneself {


    public static void main(String[] args){
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(LCS(s1,s2));
    }

    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public static String LCS (String s1, String s2) {
        // write code here
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return "-1";
        }
        int[][] dp = getDp(s1, s2);
        if(dp[s1.length()-1][s2.length()-1] == 0){
            return "-1";
        }
        String lcs = getLCS(s1, s2, dp);
        return lcs;

    }

    private static int[][] getDp(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1+1][length2+1];  //todo 注意下标，好计算

        for (int i = 0;i<length1;i++){
            for (int j = 0;j<length2;j++){
                if (s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);  // todo 如果两个字符不相等
                }
            }

        }
        return dp;
    }


    public static String getLCS(String s1,String s2,int[][] dp) {
        String lcsSequence = "";
        int i = s1.length();
        int j = s2.length();
        while (i != 0 && j != 0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                lcsSequence = s1.charAt(i-1) + lcsSequence;
                i--;
                j--;
            }else {
                if (dp[i-1][j] >= dp[i][j-1]) {
                    i--;
                }else {
                    j--;
                }
            }
        }
        return lcsSequence;
    }


}
