package nDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *  * 1. candidates 中的数字可以无限制重复被选取。
 *  * 2. candidates 中的每个数字在每个组合中只能使用一次。
 *  *
 *  * 加起来和为目标值的组合
 *  * 输入：[100,10,20,70,60,10,50],80
 *  * 返回值：[[10,10,60],[10,20,50],[10,70],[20,60]]
 *  * 说明：给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 */
public class fCombinationSum2XXX {

    public static void main(String[] args) {
        fCombinationSum2XXX fCombinationSum2XXX = new fCombinationSum2XXX();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = fCombinationSum2XXX.combinationSum(candidates, target);
        System.out.println(lists);
    }

    List<List<Integer>> res=new ArrayList();
    List<Integer> temp=new ArrayList();
    int target=0;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
