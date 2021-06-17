package kDP.number.single;

/**
 * 最大子序和
 */
public class bMaxSubArray {

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));

    }


    //todo https://leetcode-cn.com/problems/maximum-subarray/ 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

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

    /**
     * 最大子序和
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int pre = 0;
        int maxAns = nums[0]; // 最大子序和
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
