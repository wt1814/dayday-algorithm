package aTest.day0916;

public class test3 {


    // https://blog.csdn.net/weixin_43530726/article/details/88824030?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link

/*    首先我们求出数组的所有数字的和 sum，判断 sum 是否能整除 k，不能整除的话直接返回 false。
    然后需要一个 mark 数组来记录哪些数组已经被选中了，然后调用递归函数，我们的目标是组k个子集合，每个子集合的和为 subSum = sum / k。我们还需要变量 start，表示从数组的某个位置开始查找，curSum 为当前子集合的和。
    在递归函数中，如果 k = 1，说明此时只需要组一个子集合，那么当前的就是了，直接返回 true。
    如果 curSum 等于 subSum 了，那么我们再次调用递归，此时传入 k - 1，start 和 curSum 都重置为0，因为我们当前又找到了一个和为 target 的子集合，要开始继续找下一个。
    否则的话就从 start 开始遍历数组，如果当前数字已经访问过了则直接跳过，否则标记为已访问。
    然后调用递归函数，k 保持不变，因为还在累加当前的子集合，start 传入 i + 1，curSum 传入 curSum + nums[i]，因为要累加当前的数字，如果递归函数返回true了，则直接返回 true。
    否则就将当前数字重置为未访问的状态继续遍历。*/


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        boolean[] mark = new boolean[nums.length];

        for (boolean i : mark) {
            i = false;
        }
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0)  {
            return false;
        }
        return cal(nums, k, 0, 0, mark, sum / k);
    }
    private static boolean cal(int[] nums, int k, int start, int curSum, boolean[] mark, int subSum) {
        if (k == 1) {
            return true;
        }

        if (curSum == subSum){
            return cal(nums, k - 1, 0, 0, mark, subSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            if (cal(nums, k, i + 1, curSum + nums[i], mark, subSum)) {
                return true;
            }
            mark[i] = false;
        }
        return false;
    }


}
