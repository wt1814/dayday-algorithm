package lDP.string.two;

public class bLongestCommonSequenceSelf {


    public static void main(String[] args) {
        String  a = "EKhHnp06qE75TmA7036PyZdlzad49gGNsEAe0830ozh5zKD1w3ngrA7VA0OvK15v12WzqDERP375C3NJKP934O8Ix0NF412B6Kk2hbALBzYFq66r0BuSPt1KD816nwOWB0M1dK2Cg1s9O6IfQTS0bT852U78SSjk4astw2KKvudmsavy2699Ut1DN3bp0cbJuB131j6W8L7NTf8NnfznSWtF7g3UDB9O68UXU730f02WLnPGCcHOn0SRnnuXrQ862Z77Jo24H3WAmEZG5BbKztIec1OFr7kXS54k1HBN5Mqx5f6SzL6Po3LDXmIlb613ZBozxg5c9Uc3Bnssp17E1ch2ZS5LGn4TYf2CN88J2GC43k12hV4zeg23S4D3LNM31R6R3JuoMDBwHc349pzjmb7nCxWysf9csh4vC30k5185H023UI6E2Eiwys8bhb97CoDv16X40iNgb89O0c2C4y0Ew0FoHSFyePi34s2ik9H5KFgD7aCbar29j2bNxGo7ym1xO5VQouJAhmAZhBVHF6QPspcvn90zH8B2928Lae8a6JD28z38Z56Urr1MB8753xi5NfdGqA5CekTU0MStGmDBOzTE0GAfc3ygNLLTe0rwQ2WN4rX62YiwOBkX3OUJt8IR2Z7xv6u3g0E3498072lOGX6nm6zQJsV38HN4IFL9ekbWdMEr904wkK4mbEjz0ff3NB7G1x4Q42o9X2Vj5kDuSFl7HOT8CyMzw18kVoiDj3ri0EB2zl585M93rdOlcXL1acrR4m1VmRNRkj6YOsxa7g841UG77T5e2N61iZ1375A9BMKj5Li15rNKR33dXU6dNASuEBTgL4IR347M6kK40L6ui7uLW64qIUpPZvy5s3LP9827FWJEH98aB68rhp8xqUhJ6VPv4HJudP1l5wwL7g2B2o9s9P377Ed4c24e5HmDs5RU8YbB9uCGHC5da081o4C26FhJR8NSe0tIKoHPgbq31zNEmDo1nF3l1O4aSy0LF9dfthJFy0nWzyMdCy6du3bRNF8z93MKF1bJbehe16cqHXqFJI54aE3K9h8pooBgSqG4U9FH2eZT3IB21RJH24e9lrGpE8l22WOB3WmMj806890C45Few54gN5F1jBO2Ge5KqSopHaqK2FkvVStbeFkz4p143709gLtwIiww9E2Eg9VPty7Jx7ej7nmW5rfpnfwXWiD6zNg9z7J2ybs96l23868bytw8cA0H2kAA1QOidYvrA255bAZt0x5GTIrOP5I0ynCRsT54MYiDgFkJX7I7X9F2K3n369GOl8Ih3w7vwpq4f214e2l0745K9ighL6Pz7PNCO8oP5YNQ3oHXK7HV82bUSPk19kwu8xRRp8mNBAeo2W7yMe64UQD6W95fFo1NS2Q49e958w493WVL3O2t98Au6P3z3Bifb2bmQL1GXcL9VT1X3EgnmvnN03yqGVt278KLL5rJv05U7GUFOi957m8UFn5156Bg9ZcC9OM4Y2jdI1590XO9SrOF222gG13fP9WCNZ47298lZKA5h4sA20pyDqao3PP5YCCcIfTvsYy2ZR5w93s4Y8j0as32gy0ItXOzpqyp7hzik9P958hh8rEULpx1q63bo51Y3s8jLpCusP7O34REDjmixA2s2i4wbcVVshrvio1E4dJB77r2X6J3j8oW6LfmDuDpy3xy5wnJzAwjS5T78",
                b = "kQlReRfFX";
        System.out.println(LCS(a,b));
    }

    public static String LCS(String s1,String s2){
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

    /**
     * todo 错误
     * @param s1
     * @param s2
     * @param dp
     * @return
     */
    public static String getLCS(String s1,String s2,int[][] dp){

        String lcsSequence = "";
        int i = s1.length()-1;
        int j = s2.length()-1;
        while (i >0 && j >0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                lcsSequence = s1.charAt(i-1) + lcsSequence;
                i--;
                j--;
            }else if ( dp[i-1][j] >= dp[i][j-1]) {
                i--;
            }else {
                j--;
            }
        }

        return lcsSequence;
    }

    public static int[][] getDp(String s1,String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1][length2];

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
                        dp[i][j] = dp[i-1][j-1]+1;
                    }

                }else {
                    if (i == 0){
                        dp[0][j] = 0;
                    }else if (j == 0){
                        dp[i][0] = 0;
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp;
    }

}
