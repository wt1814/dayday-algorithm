package kRecursion.prune;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 生成括号
 * todo 递归 + 剪枝 （也可以改写成回溯）
 */
public class generateParenthesis {



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
        // 递归终止
        if(right == n){
            r.add(s);
        }

        // 剪枝
        if (left > n || left < right){
            return;
        }

        gp(s+"(",left+1,right,n);
        gp(s+")",left,right+1,n);

    }
}
