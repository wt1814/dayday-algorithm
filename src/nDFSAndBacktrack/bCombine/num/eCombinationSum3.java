package nDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *     所有数字都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * todo 写错，递归下标是 i ， 非startIndex
 */
public class eCombinationSum3 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 9);
        System.out.println(lists);
    }


    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        //List<Integer> path = new ArrayList<>();
        helper(result,path,k,n,0,1);
        return result;
    }

    private static void helper(List<List<Integer>> result,LinkedList<Integer> path,int k,int n,int sum,int startIndex){
        if (sum > n){
            return;
        }

        if (sum == n && path.size() == k){
            result.add(new ArrayList<>(path));
        }

        for (int i = startIndex;i<=9;i++){
            path.add(i);
            sum = sum +i;
            helper(result,path,k,n,sum,i+1); // todo todo todo 注意注意 递归下标是 i ， 非startIndex
            sum = sum - i;
            path.removeLast();
        }

    }

    // https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247494448&idx=2&sn=08f97a245ce1110a704d0d6051338922&scene=21#wechat_redirect
    // https://programmercarl.com/0216.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CIII.html#%E6%80%9D%E8%B7%AF



}
