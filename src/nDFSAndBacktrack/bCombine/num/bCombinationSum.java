package nDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo XXXXX 再看看
 * 39. 组合总和   candidates 中的数字可以无限制重复被选取
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 * 示例 1： 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
 * 示例 2： 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5] ]
 */
public class bCombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }

    // https://programmercarl.com/0039.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C.html#_39-%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C
    // https://mp.weixin.qq.com/s/4R7-pXNx12OBWManoV3qGw

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
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
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    List<List<Integer>> res=new ArrayList();
    List<Integer> temp=new ArrayList();
    int target=0;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length<=0) {
            return res;
        }
        this.target=target;
        Arrays.sort(candidates);
        List<Integer> temp=new ArrayList();
        deep(candidates,0,0,temp);
        return res;
    }

    /**
     *
     * @param candidates
     * @param value
     * @param index   index的作用为剪去那些下边枝条值小于上边枝条值的分支
     * @param temp
     */
    public void deep(int[] candidates,int value,int index, List<Integer> temp){

        if(value >target) {
            return ;
        }

        if(value==target) {
            res.add(new ArrayList(temp));
        }

        if(value<target){
            for(int i=index;i<candidates.length;i++){
                temp.add(candidates[i]);
                deep(candidates,value+candidates[i],i,temp); //todo candidates 中的数字可以无限制重复被选取。
                // deep(candidates,value+candidates[i],i+1,temp);  //todo candidates 中的每个数字在每个组合中只能使用一次。
                temp.remove(temp.size()-1);
            }
        }

    }

}
