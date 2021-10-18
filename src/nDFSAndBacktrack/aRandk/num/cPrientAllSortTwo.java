package nDFSAndBacktrack.aRandk.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 *     输入：nums = [1,1,2]
 *     输出：
 *     [[1,1,2],
 *      [1,2,1],
 *      [2,1,1]]
 */
public class cPrientAllSortTwo {

    public static void main(String[] args) {

        int[] nums = {1,1,2};
        System.out.println(permute1(nums));

    }

    // https://mp.weixin.qq.com/s/b2m2V_YP19LLZtaemJgJrQ
    // https://programmercarl.com/0047.%E5%85%A8%E6%8E%92%E5%88%97II.html#_47-%E5%85%A8%E6%8E%92%E5%88%97-ii
    // https://mp.weixin.qq.com/s/sm9v4SIkVwXVjSfu5rtW_A
    // xxx https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247484533&idx=1&sn=22984489d3cad93e5b40a218672bb204&chksm=fb419755cc361e43c112901c6d7a90d25bd9a37c60aba319f7acd0a07aaffbafe1949e87403c&scene=21#wechat_redirect
    // XXX 全排列1 https://programmercarl.com/0046.%E5%85%A8%E6%8E%92%E5%88%97.html#%E5%9B%9E%E6%BA%AF%E4%B8%89%E9%83%A8%E6%9B%B2
    /**
     * todo 剪枝
     * todo 排序：怎么剪呢？因为要过滤掉重复的，只有重复的数字才会造成重复的结果。所以第一步要做的就是对数组进行排序，排序之后相同的数字肯定是挨着的。
     * XXX 方案一：当遍历到当前数字的时候，如果数组中当前数字和前一个数字一样，并且前一个数字没有被使用，我们就跳过当前分支，也就是把当前分支给剪掉。
     * todo 当遍历到当前数字的时候，如果当前数字和数组中前一个数字一样，并且前一个数字被使用了，我们就跳过当前分支，也就是把当前分支给剪掉（和上面的相反）
     * todo 自己的方式：遍历排序后的数组，判断当前元素是否跟上一元素相等。
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        //先对数组进行排序，这样做目的是相同的值在数组中肯定是挨着的，
        //方便过滤掉重复的结果
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //boolean数组，used[i]表示元素nums[i]是否被访问过
        boolean[] used = new boolean[nums.length];
        //执行回溯算法
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> res) {
        //如果数组中的所有元素都使用完了，类似于到了叶子节点，
        //我们直接把从根节点到当前叶子节点这条路径的元素加入到集合res中
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        //遍历数组中的元素
        for (int i = 0; i < nums.length; i++) {
            //如果已经被使用过，则直接跳过
            if (used[i]){
                continue;
            }
            //注意，这里要剪掉重复的组合
            //如果当前元素和前一个一样，并且前一个被使用了，我们也跳过
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1]){
                continue;
            }
            //否则我们就使用当前元素，把它标记为已使用
            used[i] = true;
            //把当前元素nums[i]添加到tempList中
            tempList.add(nums[i]);
            //递归，类似于n叉树的遍历，继续往下走
            backtrack(nums, used, tempList, res);
            //递归完之后会往回走，往回走的时候要撤销选择
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack1(list, new ArrayList<>(), nums);
        return list;
    }

    /**
     *
     * @param list
     * @param tempList
     * @param nums
     */
    private static void backtrack1(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        // todo 输入数字有重复，下标从 0 开始
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {  // todo
                continue;
            }
            tempList.add(nums[i]);
            backtrack1(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }

}
