package nBFSAndDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class hCombine {

    public static void main(String[] args) {

        List<List<Integer>> lists = combine(2, 1);
        for (int i = 0;i<lists.size();i++){

            List<Integer> list1 = lists.get(i);
            System.out.println("aaaaaa");

            for (int j =0 ;j< list1.size();j++){
                System.out.println(list1.get(j));
            }

        }

    }



    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine(n,k,lists,list,1);
        return lists;
    }



    public static void combine(int n, int k,List<List<Integer>> lists,List<Integer> list,int index){

        // todo 缺剪枝

        // 递归终止条件
        if (list.size() == k){
            if (!lists.contains(list)){
                lists.add(new ArrayList<>(list));
            }

            return;
        }

        for (int i=index;i<=n;i++){

            // todo 1. 放，并进入下一轮
            // 放
            list.add(i);
            // 进入下一轮
            combine(n,k,lists,list,index+1);
            // todo 2. 回溯
            list.remove(list.size()-1);
            // todo 3. 不放，直接进入下一轮
            combine(n,k,lists,list,index+1);

        }

    }

}

