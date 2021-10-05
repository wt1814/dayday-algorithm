package nBFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 加起来和为目标值的组合
 *
 * 输入：[100,10,20,70,60,10,50],80
 * 返回值：[[10,10,60],[10,20,50],[10,70],[20,60]]
 * 说明：给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 *
 */
public class cCombinationSum {


    // https://www.nowcoder.com/practice/75e6cd5b85ab41c6a7c43359a74e869a?tpId=188&&tqId=38629&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(num == null || num.length==0 || target<0)return res;
        Arrays.sort(num);
        dfs(num,target,res,arr,0);
        return res;
    }

    public void dfs(int[] num,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> arr,int start){
        if(target==0){
            res.add(new ArrayList<Integer>(arr));
            return;
        }
        if(start >= num.length)return;
        for(int i=start;i<num.length;i++){
            if(i > start && num[i] == num[i-1])continue;
            if(num[i] <= target){
                arr.add(num[i]);
                dfs(num,target-num[i],res,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
        return;
    }


    /////////////////////////////

/*    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        vector<vector<int> > res;
        vector<int> tmp;
        if (num.empty()) return res;
        sort(num.begin(), num.end());//对候选素组进行排序，在一定程度上可以优化搜索
        aDFS(num, target, res, tmp, 0);//开始搜索 刚开始start=0 从第一个开始搜索
        return res;//返回最后的结果
    }

    void aDFS(vector<int> &num, int target, vector<vector<int> > &res, vector<int> &tmp, int start) {
        if (target==0) {//当每一个小组的target=0的时候 说明该分组已经分好了 直接存进res中
            res.push_back(tmp);
            return;//末端终止 避免无效搜索
        }
        if (start>=num.size()) return;//当开始搜索的位置大于候选数字的时候 整个搜索结束
        for (int i=start;i<num.size(); ++i) {//从start到候选数组末尾开始搜索
            //去重处理 若相等 直接continue 避免重复搜索
            if (i>start&&num[i]==num[i-1]) continue;
            //剪枝
            //前面的排序就有意义了 这块要是剩余的num[i]的值已经大于target的大小 后面已经是无效搜索了
            if (num[i] <= target) {
                //后面是一个回溯的过程先加入tmp 后从tmp末端删除 确保可以搜索可以进行下去
                tmp.push_back(num[i]);
                //由于num[i]加入 target的大小减去num[i] 搜索开始位置往后 也就是start+1
                aDFS(num, target - num[i], res, tmp, i + 1);
                tmp.pop_back();
            }
        }
    }*/


}

