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


    /**
     *
     * @param arr
     * @return
     */
    public static int[] getdp1(int arr[]){
        int[] dp= new int[arr.length];
        for(int i=0;i<arr.length;i++){ // 以i为尾
            dp[i]=1;
            for(int j=0;j<i;j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return dp;
    }

    //如果还需要求出递增序列的话，可以这么做：
    //首先我们arr从右往左找出最大值，然后根据这个最大值往前递推，满足：
    //arr[j] < arr[i] && dp[i] = dp[j] +1

    /**
     *
     * @param arr
     * @param dp
     * @return
     */
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

}
