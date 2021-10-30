package nDFSAndBacktrack.dDivision;

/**
 * 494. DFS解目标和问题
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *     例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */
public class fZZZFindTargetSumWays {

    // https://mp.weixin.qq.com/s/ZNY-7G7IGAFFLxrWD3eAcQ
    // 在数组中每个元素前面添加'+'或'-'，组成算术表达式并且他的和等于target，问有多少种方式。每个元素只能有两种选择，要么添加'+'要么添加'-'，所以我们很容易想到的是二叉树。假如使用数组[1,1,1,1]中的所有元素通过'+'或'-'符号构成2
    // 让每个节点的左子节点选择'-'，右子节点选择'+'，计算从根节点到叶子节点所有元素的和是否等于target，如果等于，说明找到了一个满足条件的表达式，只需要计算所有满足条件的个数即可
    //不同表达式的数目
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    //从根节点开始往下累加，到叶子节点的时候如果累加值等于target，
    //说明找到了一条符合条件的表达式
    private void dfs(int[] nums, int target, int sum, int index) {
        //判断从根节点到当前叶子节点这条路径是否走完了
        if (index == nums.length) {
            //如果当前累加值等于target，说明找到了一条符号条件的表达式
            if (target == sum){
                count++;
            }
            return;
        }
        //todo 左子树数负数，要减去
        dfs(nums, target, sum - nums[index], index + 1);
        //todo 右子树是正数，要加上
        dfs(nums, target, sum + nums[index], index + 1);
    }

}