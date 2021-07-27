package aTest.day0727;

public class Solution {

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


    public static String getLCS(String s1,String s2,int[][] dp){

        String lcsSequence = "";
        int i = s1.length();
        int j = s2.length();
        while (i != 0 && j != 0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                lcsSequence = s1.charAt(i-1) + lcsSequence;
                i--;
                j--;
            }else {
                if (dp[i-2][j-1] >= dp[i-1][j-2]) {
                    i--;
                }else {
                    j--;
                }
            }
        }

        return lcsSequence;
    }

    public static int[][] getDp(String s1,String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1][length2];  //todo 长度是length1，最大下标是length1-1

        for(int i = 0;i<length1;i++){
            for (int j= 0;j<length2;j++){
                if (s1.charAt(i) == s2.charAt(j)){
/*                    if (i == 0){
                        dp[0][j] = 1;
                    }else if (j == 0){
                        dp[i][0] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }*/
                    if (i == 0 || j == 0){    //todo 第0行或第0列值
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1]+1;  //todo 如果两个字符相等
                    }

                }else {
                    if (i == 0){
                        dp[0][j] = 0;
                    }else if (j == 0){
                        dp[i][0] = 0;
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);  // todo 如果两个字符不相等
                    }
                }
            }
        }
        return dp;
    }


    public static int[][] getDP(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] result = new int[len1-1][len2-1];
        for(int i = 0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0 || j==0){
                        result[i][j] = 1;
                    }else{
                        result[i][j] = result[i-1][j-1] +1;
                    }
                }else{
                    if(i == 0){
                        result[0][j] = 0;
                    }else if(j == 0){
                        result[i][0] = 0;
                    }else{
                        result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                    }

                }

            }
        }
        return result;
    }
}