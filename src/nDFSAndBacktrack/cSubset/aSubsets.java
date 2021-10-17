package nDFSAndBacktrack.cSubset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class aSubsets {



    /////////////////////////////////////////////////////////////////////

    /**
     * 如果把 子集问题、组合问题、分割问题都抽象为一棵树的话，
     * todo 那么组合问题和分割问题都是收集树的叶子节点，
     * todo 而子集问题是找树的所有节点！
     */
    // https://programmercarl.com/0078.%E5%AD%90%E9%9B%86.html
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){

        result.add(new ArrayList<>(path));//todo「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。

        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }

    }


    /////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/EueIRW0XqBp4ppuRxneNAg
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //做出选择
            tempList.add(nums[i]);
            //递归
            backtrack(list, tempList, nums, i + 1);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }

}