package cArray.prefixAnd.oneDimensional;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 */
public class dZZZSubarraySum {


    // 前缀和技巧 https://zhuanlan.zhihu.com/p/107778275


    // https://mp.weixin.qq.com/s/qSSoNpt18JKVBKx07zYdnw
    /**
     * 前缀和求解
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        //先计算前缀和，pre[i]表示数组nums中前i个元素的和
        int[] pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j <= nums.length; j++) {
            //计算pre[i-1]+pre[j]=k，我们只需要找出pre[i-1]
            //的个数即可，这个可以通过map来查找
            int other = pre[j] - k;
            if (map.containsKey(other)) {
                //如果map中存在pre[i-1]，把他的个数进行累加
                count += map.get(other);
            }
            //pre[j]的个数加1在放到map中
            map.put(pre[j], map.getOrDefault(pre[j], 0) + 1);
        }

        return count;
    }

}
