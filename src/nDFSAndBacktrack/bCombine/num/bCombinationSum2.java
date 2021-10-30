package nDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.组合总和II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明： 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。
 *
 * 示例 1: 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * 示例 2: 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]
 */
public class bCombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2,3,5,7};
        int target = 5;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }



    // https://programmercarl.com/0040.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CII.html
    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); //todo 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;

    }

    public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {

        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path)); // todo
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {  // todo 剪枝
                break;
            }
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i+1); //todo 只能使用一次，下标从i+1开始
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }

    }

}
