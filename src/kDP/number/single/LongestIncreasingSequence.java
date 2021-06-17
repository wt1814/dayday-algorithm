package kDP.number.single;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LongestIncreasingSequence {

    // https://blog.csdn.net/u012505432/article/details/52228945


    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] ints = lis1(arr);

        Arrays.stream(ints).forEach(value -> System.out.print(value));
    }

    public static int[] lis1 (int[] arr){
        int[] dp = getdp1(arr);
        return generateLIS(arr,dp);
    }


    public static int[] generateLIS(int[] arr,int[] dp){
        if (arr == null || arr.length == 0){
            return null;
        }

        int len = 0;
        int index = 0;

        for (int i = 0;i<dp.length;i++){
            if (dp[i] >len){
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

    public static int[] getdp1(int arr[]){
        int[] dp= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return dp;
    }




}
