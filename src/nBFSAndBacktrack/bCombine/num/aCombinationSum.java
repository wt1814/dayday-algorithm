package nBFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 1. candidates 中的数字可以无限制重复被选取。
 * 2. candidates 中的每个数字在每个组合中只能使用一次。
 */
public class aCombinationSum {


    List<List<Integer>> res=new ArrayList();
    List<Integer> temp=new ArrayList();
    int target=0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length<=0) return res;
        this.target=target;
        Arrays.sort(candidates);
        List<Integer> temp=new ArrayList();
        deep(candidates,0,0,temp);
        return res;
    }

    //index的作用为剪去那些下边枝条值小于上边枝条值的分支
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
