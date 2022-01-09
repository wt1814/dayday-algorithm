package aaSummary.fSlidingWindow.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 双指针解三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 */
public class bThreeSum {

    public static void main(String[] args) {

    }


    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484423&idx=1&sn=ff37a4bb96de487601d8ea7df59ef794&chksm=fd9caf18caeb260e101a6efe1809663dda5ef7d83d0f8a5df3d7e5e4edb6634f67ea39fab4cf&scene=178&cur_album_id=1748659352518868992#rd
    /**
     * 对数组进行排序，使用三个指针 i、j 和 k 分别代表要找的三个数。
     *
     * 1. 通过枚举 i 确定第一个数，
     *  todo 另外两个指针 j，k 分别从左边 i + 1 和右边 n - 1 往中间移动，
     *  找到满足 nums[i] + nums[j] + nums[k] == 0 的所有组合。
     *
     * 2. j 和 k 指针的移动逻辑，分情况讨论 sum = nums[i] + nums[j] + nums[k] ：
     *         sum > 0：k 左移，使 sum 变小
     *         sum < 0：j 右移，使 sum 变大
     *         sum = 0：找到符合要求的答案，存起来
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = n - 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (k - 1 > j && nums[i] + nums[j] + nums[k - 1] >= 0) {
                    k--;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return ans;
    }
    // todo 时间复杂度：排序的复杂度为 O(n * logn)，对于每个 i 而言，最坏的情况 j 和 k 都要扫描一遍数组的剩余部分，复杂度为O(n^2) 。整体复杂度为O(n^2)
    // todo 空间复杂度：


    ////////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/NvPpOIbCc_0SRpJqKMgcrA
    /**
     *
     * @param num
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] num) {
        //先对数组进行排序
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //过滤掉重复的
            if (i > 0 && num[i] == num[i - 1]){
                continue;
            }
            //因为是排序的，如果第一个数字大于0，那么后面的也都
            //大于0，他们三个数字的和不可能等于0
            if (num[i] > 0){
                break;
            }
            int left = i + 1;//左指针
            int right = num.length - 1;//右指针
            int target = -num[i];
            while (left < right) {
                //左右指针的和
                int sum = num[left] + num[right];
                if (sum == target) {
                    //找到了一组，把他们加入到集合list中
                    res.add(Arrays.asList(num[i], num[left], num[right]));
                    //过滤掉重复的
                    while (left < right && num[left] == num[left + 1]){
                        left++;
                    }
                    while (left < right && num[right] == num[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /*
      todo 排序的时间复杂度是O(nlogn)，for循环中的时间复杂度是O(n)，for循环里面的时间复杂度是O(n)，他们是相乘的关系，所以他们的时间复杂度是O(n^2)，整个代码的时间复杂度就是O(nlogn)+O(n^2)，也就是O(n^2)。
    */

}
