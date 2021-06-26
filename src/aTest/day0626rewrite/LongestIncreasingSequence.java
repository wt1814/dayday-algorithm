package aTest.day0626rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: LongestIncreasingSequence
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/27/21 12:28 AM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class LongestIncreasingSequence {

    public static void main(String[] args){
        int[] arr = {1,2,8,6,4};
        int[] ints = lis1(arr);

        Arrays.stream(ints).forEach(value -> System.out.print(value));
    }

    public static int[] lis1 (int[] arr){
        int[] dp = getdp1(arr);
        return generateLIS(arr,dp);
    }

    private static int[] getdp1(int[] arr) {

        int[] dp = new int[arr.length];


        for (int i=0;i<arr.length;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

        }

        return dp;
    }

    public static int[] generateLIS(int[] arr,int[] dp){
        if (arr == null || arr.length == 0){
            return null;
        }

        int len = 0;
        int index = 0;

        for (int i = 0;i<dp.length;i++){
            if (dp[i] >len){ //todo 如果找 "字典序最小的最长递增子序列"，则条件修改为 ">="
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index;i>=0;i--){
            if (arr[i] < arr[index] && dp[i] == dp[index]-1){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }


}
