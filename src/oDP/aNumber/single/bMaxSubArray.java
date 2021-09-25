package oDP.aNumber.single;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class bMaxSubArray {


    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxsumofSubarray(nums));
        System.out.println(maxSubArray2(nums));

    }

    /////////////////////////////
    /**
     * todo 自己写的
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public  static int maxsumofSubarray (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0){
            return 0;
        }

        //
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        // 生成dp数组
        for(int i = 1;i<arr.length;i++){
            if(dp[i-1]>0){
                dp[i] = dp[i-1]+arr[i];
            }else{
                dp[i] = arr[i];
            }
        }

        //
        int result = dp[0];
        for(int i = 0;i<dp.length;i++){
            if(dp[i] > result){
                result = dp[i];
            }
        }

        return result;
    }


    //////////////////////////////////

    // https://mp.weixin.qq.com/s/GvBPILaDVhjVhtVDQRLs5g
    // https://leetcode-cn.com/problems/maximum-subarray/
    // https://www.cnblogs.com/dddyyy/p/10746769.html
    // https://mp.weixin.qq.com/s/GvBPILaDVhjVhtVDQRLs5g

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

    //////////

    int maxSubArray3(int[] nums) {


        if (nums.length == 0){
            return 0;
        }

        // dp数组 采用一维数组与入参相似

        // base case
        int maxSum = nums[0];


        for (int i = 1; i < nums.length; ++i) {
            // max = Math.max(max + array[i], array[i]);
            nums[i] = Math.max(nums[i - 1], 0) + nums[i]; // todo 状态转移方程

            // dp[i]=max(dp[i-1]+nums[i],nums[i])，其中i>=1，
            // 当dp[i-1]<0 时，抛弃当前的和最大的连续子数组，从nums[i]开始重新寻找和最大的连续子数组，
            // 否则将nums[i]加入到当前的和最大的连续子数组。
            maxSum = Math.max(maxSum, nums[i]);
        }

        return maxSum;
    }


    /////
    // leetcode原解
    public int maxSubArray4(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
