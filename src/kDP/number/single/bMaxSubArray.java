package kDP.number.single;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class bMaxSubArray {

    // https://mp.weixin.qq.com/s/GvBPILaDVhjVhtVDQRLs5g

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));

    }


    // https://mp.weixin.qq.com/s/GvBPILaDVhjVhtVDQRLs5g
    // https://leetcode-cn.com/problems/maximum-subarray/
    // https://www.cnblogs.com/dddyyy/p/10746769.html


    /**
     *
     * @param array
     * @return
     */
    public static int maxSubArray2(int[] array){

        if (array.length == 0){
            return 0;
        }

        // dp数组
        int res = 0;
        // base case
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]); // todo 状态转移方程
            // dp[i]=max(dp[i-1]+nums[i],nums[i])，其中i>=1，
            // 当dp[i-1]<0 时，抛弃当前的和最大的连续子数组，从nums[i]开始重新寻找和最大的连续子数组，
            // 否则将nums[i]加入到当前的和最大的连续子数组。
            res = Math.max(res, max);
        }
        return res;
    }


    ////////////////

    public static int maxSubArray(int[] nums) {// 动态规划法
        int sum=nums[0]; // dp数组
        int n=nums[0];  // 初始值，前n个子序列和

        for(int i=1;i<nums.length;i++) {

            if(n>0){
                n+=nums[i];  //todo 如果当前元素大于0
            } else {
                n=nums[i];
            }

            if(sum<n){   //todo 更新当前子序列和
                sum=n;
            }
        }
        return sum;
    }

}
