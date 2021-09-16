package aTest.day0916;

import java.util.Arrays;
import java.util.List;

public class test {


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums,4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // 不能均分，直接返回false
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }

        // 能均分，计算平均分
        int score = sum / k;
        // 标记数组
        boolean[] flag = new boolean[nums.length];
        Arrays.fill(flag, false);

        return helper(nums, k, flag, 0, score, 0);

    }

    private static boolean helper(int[] nums, int k, boolean[] flag, int curnum, int score, int pos) {
        // 最终终止条件：只有一个分组的情况，也可能是前面的已经分组完了，就剩一个了，也表示没问题了
        if (k == 1) {
            return true;
        }
        // 每一轮的终止条件：这一轮满足条件了，可以下一轮了
        if (curnum == score) {
            return helper(nums, k - 1, flag, 0, score, 0);
        }
        // 从头开始新的一轮，子集的累计和
        for (int i = pos; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            if (helper(nums, k, flag, curnum + nums[i], score, i + 1)) {
                return true;
            }
            flag[i] = false;
        }
        return false;
    }
}
