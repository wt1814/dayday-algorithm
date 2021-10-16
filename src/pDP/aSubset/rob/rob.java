package pDP.aSubset.rob;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class rob {

    // https://leetcode-cn.com/problems/house-robber/



    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247489154&idx=1&sn=b91f94eb6c3fe27e0fc4fd7b40909fc1&chksm=fb4185a2cc360cb4ca4b16c1112b0f27dd27dca214457ff47739b17b6726a944706504a056d4&scene=178&cur_album_id=1360108212447526913#rd
    /**
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        return robHelper(nums, nums.length - 1);
    }

    /**
     * 递归方式解打家劫舍
     * @param nums
     * @param i
     * @return
     */
    private int robHelper(int[] nums, int i) {
        //终止条件
        if (i < 0)
            return 0;
        //偷上上家之前所能得到的最大值
        int lastLast = robHelper(nums, i - 2);
        //偷上家之前所能得到的最大值
        int last = robHelper(nums, i - 1);
        //偷上上家之前的还可以再偷当前这一家
        int cur = lastLast + nums[i];
        //然后返回偷当前这一家和不偷当前这一家的最大值
        return Math.max(last, cur);
    }

}
