package rBitOperation;

/**
 * 268. 丢失的数字
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 *     n == nums.length
 *     1 <= n <= 104
 *     0 <= nums[i] <= n
 *     nums 中的所有数字都 独一无二
 *
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 **/
public class dMissingNumber {

    // https://mp.weixin.qq.com/s?__biz=Mzk0NzIxMDgwNA==&mid=2247484607&idx=1&sn=0aef15175101b8f67c32272f8fcbcc89&chksm=c37b1be4f40c92f260b673c64314d5598f922d9d21ac47b7703494e2a607f71723cc8aae862a&scene=178&cur_album_id=1990389635625091072#rd
    // https://mp.weixin.qq.com/s/jQAi8gpctRR5V6gahFnHpQ

    public static void main(String[] args) {

    }

    /**
     * todo 转化为只出现一次的数字
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

}
