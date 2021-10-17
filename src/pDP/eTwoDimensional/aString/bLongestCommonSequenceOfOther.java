package pDP.eTwoDimensional.aString;

/**
 * 最长公共子序列
 */
public class bLongestCommonSequenceOfOther {

    public static void main(String[] args) {
        String  a = "EKhHnp06qE75TmA7036PyZdlzad49gGNsEAe0830ozh5zKD1w3ngrA7VA0OvK15v12WzqDERP375C3NJKP934O8Ix0NF412B6Kk2hbALBzYFq66r0BuSPt1KD816nwOWB0M1dK2Cg1s9O6IfQTS0bT852U78SSjk4astw2KKvudmsavy2699Ut1DN3bp0cbJuB131j6W8L7NTf8NnfznSWtF7g3UDB9O68UXU730f02WLnPGCcHOn0SRnnuXrQ862Z77Jo24H3WAmEZG5BbKztIec1OFr7kXS54k1HBN5Mqx5f6SzL6Po3LDXmIlb613ZBozxg5c9Uc3Bnssp17E1ch2ZS5LGn4TYf2CN88J2GC43k12hV4zeg23S4D3LNM31R6R3JuoMDBwHc349pzjmb7nCxWysf9csh4vC30k5185H023UI6E2Eiwys8bhb97CoDv16X40iNgb89O0c2C4y0Ew0FoHSFyePi34s2ik9H5KFgD7aCbar29j2bNxGo7ym1xO5VQouJAhmAZhBVHF6QPspcvn90zH8B2928Lae8a6JD28z38Z56Urr1MB8753xi5NfdGqA5CekTU0MStGmDBOzTE0GAfc3ygNLLTe0rwQ2WN4rX62YiwOBkX3OUJt8IR2Z7xv6u3g0E3498072lOGX6nm6zQJsV38HN4IFL9ekbWdMEr904wkK4mbEjz0ff3NB7G1x4Q42o9X2Vj5kDuSFl7HOT8CyMzw18kVoiDj3ri0EB2zl585M93rdOlcXL1acrR4m1VmRNRkj6YOsxa7g841UG77T5e2N61iZ1375A9BMKj5Li15rNKR33dXU6dNASuEBTgL4IR347M6kK40L6ui7uLW64qIUpPZvy5s3LP9827FWJEH98aB68rhp8xqUhJ6VPv4HJudP1l5wwL7g2B2o9s9P377Ed4c24e5HmDs5RU8YbB9uCGHC5da081o4C26FhJR8NSe0tIKoHPgbq31zNEmDo1nF3l1O4aSy0LF9dfthJFy0nWzyMdCy6du3bRNF8z93MKF1bJbehe16cqHXqFJI54aE3K9h8pooBgSqG4U9FH2eZT3IB21RJH24e9lrGpE8l22WOB3WmMj806890C45Few54gN5F1jBO2Ge5KqSopHaqK2FkvVStbeFkz4p143709gLtwIiww9E2Eg9VPty7Jx7ej7nmW5rfpnfwXWiD6zNg9z7J2ybs96l23868bytw8cA0H2kAA1QOidYvrA255bAZt0x5GTIrOP5I0ynCRsT54MYiDgFkJX7I7X9F2K3n369GOl8Ih3w7vwpq4f214e2l0745K9ighL6Pz7PNCO8oP5YNQ3oHXK7HV82bUSPk19kwu8xRRp8mNBAeo2W7yMe64UQD6W95fFo1NS2Q49e958w493WVL3O2t98Au6P3z3Bifb2bmQL1GXcL9VT1X3EgnmvnN03yqGVt278KLL5rJv05U7GUFOi957m8UFn5156Bg9ZcC9OM4Y2jdI1590XO9SrOF222gG13fP9WCNZ47298lZKA5h4sA20pyDqao3PP5YCCcIfTvsYy2ZR5w93s4Y8j0as32gy0ItXOzpqyp7hzik9P958hh8rEULpx1q63bo51Y3s8jLpCusP7O34REDjmixA2s2i4wbcVVshrvio1E4dJB77r2X6J3j8oW6LfmDuDpy3xy5wnJzAwjS5T78",
                b = "kQlReRfFX";
        System.out.println("左神 "+lcse(a,b));
        System.out.println("-----------------");
        System.out.println(compute(a, b));
        System.out.println("-----------------");
        System.out.println(LCS(a, b));
        System.out.println("-----------------");
        maxCommonChar(a.toCharArray(),b.toCharArray());

    }


    // *** https://mp.weixin.qq.com/s/ZhPEchewfc03xWv9VP3msg
    // todo 视频讲解 https://leetcode-cn.com/problems/longest-common-subsequence/solution/shi-pin-jiang-jie-shi-yong-dong-tai-gui-hua-qiu-ji/

    // 左神

    public static String lcse(String str1, String str2)
    {
        int m = str1.length()-1;
        int n = str2.length()-1;
        int[][] dp = new int[m+1][n+1];
        dp = getdp(str1, str2);
        char[] res = new char[dp[m][n]];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("") || dp[m][n] == 0) {
            return "-1";
        }
        int index = res.length - 1;
        //比如res数组长度为7，实际计算过程并不是7次，而是大于等于7次
        while(index >= 0) {
            if(n > 0 && dp[m][n] == dp[m][n-1])//来自左
            {
                n--;
            }
            else if(m > 0 && dp[m][n] == dp[m-1][n])//来自上
            {
                m--;
            }
            else
            {
                //dp[m][n] == dp[m-1][n-1] + 1 || dp[0][n] == dp[0][n-1] + 1 || dp[m][0] == dp[m-1][0] + 1
                res[index--] = str1Arr[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    public static int[][] getdp(String str1, String str2)
    {
        int[][] dp = new int[str1.length()][str2.length()];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        dp[0][0] = str1Arr[0] == str2Arr[0] ? 1 : 0 ;
        for(int i = 1; i < str1.length(); i++)
        {
            //第零列
            dp[i][0] = Math.max(dp[i-1][0], (str1Arr[i] == str2Arr[0] ? 1 : 0));
        }
        for(int j = 1; j < str2.length(); j++)
        {
            //第零行
            dp[0][j] = Math.max(dp[0][j-1], (str1Arr[0] == str2Arr[j] ? 1 : 0));
        }

        for(int i = 1; i < str1.length(); i++)
        {
            for(int j = 1; j < str2.length(); j++)
            {
                //先比较左和上，取大者
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                if(str1Arr[i] == str2Arr[j])
                {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
                }
            }
        }
        return dp;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////
    public static int compute(String a, String b) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;

        int[][] longestValeMatrix = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(str1[i-1] == str2[j-1]) {
                    longestValeMatrix[i][j] = longestValeMatrix[i-1][j-1] + 1;
                } else {
                    longestValeMatrix[i][j] = Math.max(longestValeMatrix[i-1][j], longestValeMatrix[i][j-1]);
                }
            }
        }

        System.out.println("the first String is: " + new String(str1));
        System.out.println("the second String is: " + new String(str2));
        String lcsSequence = "";

        int i = len1, j = len2;
        while(i>0 && j>0) {
            if(str1[i-1] == str2[j-1]) {
                lcsSequence = str1[i-1] + lcsSequence;
                i--;
                j--;
            } else if (longestValeMatrix[i-1][j] >= longestValeMatrix[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("the longest common subsequence is: " + lcsSequence);
        return longestValeMatrix[len1][len2];

    }


    ////////////////////////////////////////////////////////////////////////////////////////////
    //求解str1 和 str2 的最长公共子序列
    public static int LCS(String str1, String str2){
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for(int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for(int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;

        for(int i = 1; i <= str1.length(); i++)
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    c[i][j] = c[i-1][j-1] + 1;
                }else if(c[i][j-1] > c[i-1][j]){
                    c[i][j] = c[i][j-1];
                }else{
                    c[i][j] = c[i-1][j];
                }
            }
        return c[str1.length()][str2.length()];
    }


    ////////////////////////////////////////////////////////////////////////////////////////////
    public static void maxCommonChar(char [] a, char [] b){
        int m = a.length;
        int n = b.length;
        int [][] len = new int[m + 1][n + 1];
        int [][] flags = new int[m + 1][n + 1];
        for(int i = 0; i <= m - 1; i++){
            for(int j = 0; j <= n - 1; j++){
                if(a[i] == b[j]){
                    len[i + 1][j + 1] = len[i][j] + 1;
                    flags[i + 1][j + 1] = 1;
                }else if(len[i + 1][j] >= len[i][j + 1]){
                    len[i + 1][j + 1] = len[i + 1][j];
                    flags[i + 1][j + 1] = 2;
                }else{
                    len[i + 1][j + 1] = len[i][j + 1];
                    flags[i + 1][j + 1] = 3;
                }
            }
        }
        int k = len[m][n];
        char [] commonChars = new char[k];
        int i = m, j = n;
        for(;i > 0 && j > 0;){
            if(flags[i][j]==1){
                commonChars[k - 1] = a[i - 1];
                k--;
                i--;
                j--;
            }else if(flags[i][j] == 2){
                j--;
            }else{
                i--;
            }
        }

        for(int l = 0; l <= len[m][n] - 1; l++){
            System.out.print(commonChars[l]);
        }
    }

}
