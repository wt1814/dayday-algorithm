package pDP.aSubset;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 *
 * 如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个
 */
public class cLongestIncreasingSequence {



    public static void main(String[] args){
        int[] arr = {1,2,8,6,4};
        int[] ints = lis(arr);
        Arrays.stream(ints).forEach(value -> System.out.print(value));
    }


    // https://blog.csdn.net/u012505432/article/details/52228945
    // https://mp.weixin.qq.com/s/7QFapCuvi-2nkh6gREcR9g
    // https://mp.weixin.qq.com/s/HJTbehi5JfvOFM1ZSxDxow

    /**
     *
     * @param arr
     * @return
     */
    public static int[] lis (int[] arr){
        int[] dp = getdp1(arr);
        int[] ints = generateLIS(arr, dp);
        return ints;
    }


    /**
     * todo 生成dp数组
     * @param arr
     * @return
     */
    public static int[] getdp1(int arr[]){

        int[] dp= new int[arr.length];
        for(int i=0;i<arr.length;i++){ // 遍历原数组
            dp[i]=1;   // todo todo todo dp数组 base case是每个位置的值都为1
            for(int j=0;j<i;j++){   //todo todo todo dp数组结果集中，dp[i]依赖前面的结果
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

    //todo 如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个
    // https://www.nowcoder.com/practice/9cf027bf54714ad889d4f30ff0ae5481?tpId=188&&tqId=38586&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    // 对于第二步，假设我们原始数组是arr1，得到的maxLen为[1,2,3,1,3]，最终输出结果为res（字典序最小的最长递增子序列），
    // res的最后一个元素在arr1中位置无庸置疑是maxLen[i]==3对应的下标，那么到底是arr1[2]还是arr1[4]呢？
    // 如果是arr1[2]，那么arr1[2]<arr1[4]，则maxLen[4]==4，与已知条件相悖。因此我们应该取arr1[4]放在res的最后一个位置。

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
