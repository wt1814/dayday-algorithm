package mRecursion.prune;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 生成括号
 * todo 递归 + 剪枝 （也可以改写成回溯）
 * todo 通过DFS实现回溯，关键在于两点： 去重（好好理解一下） ； 剪枝（不剪枝会超时）。
 */
public class bGenerateParenthesis {

    static ArrayList<String> r = new ArrayList<String>();

    public static void main(String[] args) {

        ArrayList<String> strings = generateParenthesis(3);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    // https://www.bilibili.com/video/BV1x5411j7KN/?spm_id_from=333.788.recommend_more_video.1

    public static ArrayList<String> generateParenthesis(int n) {
        //保证左边‘（’的数量始终大于等于右边的‘）’数量，可以考虑回溯法
        ArrayList<String> s = new ArrayList<String>();
        gp("",0,0,n);
        return r;
    }

    private static void gp(String s,int left,int right,int n){

        // todo 剪枝
        if (left > n || left < right){
            return;
        }

        // 递归终止
        if(right == n){
            r.add(s);
        }

        gp(s+"(",left+1,right,n);
        gp(s+")",left,right+1,n);

    }

    //////////////////////////////

    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res , String ans, int leftCount, int rightCount, int n){
        //括号数量超过了n，结束递归。
        if(leftCount > n || rightCount > n) return;
        //如果左括号和右括号数量相等且都为n，将这个序列添加进结果，剪枝。
        if(leftCount == n && rightCount == n) {
            res.add(ans);
            return;
        }
        /*
        如果左括号数量不小于右括号数量，也隐含了剪枝。
        其实省略了下面这行代码
        if(leftCount < rightCOunt) return;
         */
        if(leftCount >= rightCount){
            //加一个左括号
            generate(res, ans+"(", leftCount+1, rightCount, n);
            //加一个右括号
            generate(res, ans+")", leftCount, rightCount+1, n);
        }
    }

    ////////////////////////////

    // https://blog.csdn.net/sc179/article/details/115023844
    List<String> res = new ArrayList<>();
    StringBuilder ans = new StringBuilder();
    int max;
    public List<String> generateParenthesis2(int n) {
        max = n;
        backtrack(0, 0);
        return res;
    }

    public void backtrack(int open, int close) {
        if (ans.length() == max * 2) {
            res.add(ans.toString());
            return;
        }
        if (open < max) {
            ans.append('(');
            backtrack(open + 1, close);
            ans.deleteCharAt(ans.length() - 1);
        }
        if (close < open) {
            ans.append(')');
            backtrack(open, close + 1);
            ans.deleteCharAt(ans.length() - 1);
        }
    }



}
