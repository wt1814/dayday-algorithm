package aTest.day0713;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/13/21 2:17 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {


    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "edf";

        System.out.println(LCS(s1,s2));

    }

    public static String LCS (String s1, String s2) {
        // write code here

        int[][] dp = getDP(s1,s2);
        if(dp[s1.length()-1][s2.length()-1] == 0){
            return "-1";
        }

        return "-2";

    }


    public static int[][] getDP(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] result = new int[len1][len2];
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
