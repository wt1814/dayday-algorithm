package nDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.Arrays;

public class eCombinationSum2XXX {


    // https://www.nowcoder.com/practice/75e6cd5b85ab41c6a7c43359a74e869a?tpId=188&&tqId=38629&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(num == null || num.length==0 || target<0){
            return res;
        }
        Arrays.sort(num); //对候选素组进行排序，在一定程度上可以优化搜索
        dfs(num,target,res,arr,0); //开始搜索 刚开始start=0 从第一个开始搜索
        return res;
    }

    public void dfs(int[] num,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> arr,int start){
        if(target==0){   //当每一个小组的target=0的时候 说明该分组已经分好了 直接存进res中
            res.add(new ArrayList<Integer>(arr));
            return;
        }
        if(start >= num.length){  //当开始搜索的位置大于候选数字的时候 整个搜索结束
            return;
        }
        for(int i=start;i<num.length;i++){ //从start到候选数组末尾开始搜索
            //去重处理 若相等 直接continue 避免重复搜索
            if(i > start && num[i] == num[i-1]){
                continue;
            }
            //剪枝
            //前面的排序就有意义了 这块要是剩余的num[i]的值已经大于target的大小 后面已经是无效搜索了
            if(num[i] <= target){
                arr.add(num[i]); //后面是一个回溯的过程先加入tmp 后从tmp末端删除 确保可以搜索可以进行下去
                dfs(num,target-num[i],res,arr,i+1); //由于num[i]加入 target的大小减去num[i] 搜索开始位置往后 也就是start+1
                arr.remove(arr.size()-1);
            }
        }
        return;
    }


}
