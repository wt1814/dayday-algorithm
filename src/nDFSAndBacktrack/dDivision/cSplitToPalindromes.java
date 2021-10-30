package nDFSAndBacktrack.dDivision;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 551，回溯算法解分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是「回文串」。
 * 返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class cSplitToPalindromes {



    public static void main(String[] args) {

        String s = "aabb";
        List<List<String>> partition = partition2(s);
        System.out.println(partition);
    }


    // *** 131. 分割回文串动态规划 + 回溯算法  https://mp.weixin.qq.com/s/pCAuQmSwqNSF2roIXcqtWg


    ///////////////////////////////////////////////////////////////////////
    // *** https://mp.weixin.qq.com/s/SrBfADlsOXjeOX4Cr4pQNg
    // https://programmercarl.com/0131.%E5%88%86%E5%89%B2%E5%9B%9E%E6%96%87%E4%B8%B2.html#%E6%80%BB%E7%BB%93

    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    private void backTracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    ///////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247491154&idx=1&sn=de5214414d1e122530c67e035be7cef4&chksm=fb418d72cc360464a835ba9ec4f7b7f1f9f998245bfcd901c9af29fd072f153519305540d9a9&scene=21#wechat_redirect
    public static List<List<String>> partition2(String s) {
        //最终要返回的结果
        List<List<String>> res = new ArrayList<>();
        backTrack(s, 0, res, new ArrayList<>());
        return res;
    }

    public static void backTrack(String s, int index, List<List<String>> res, List<String> cur) {
        //边界条件判断，如果字符串s中的字符都访问完了（类似于到叶子节点了），就停止查找，
        //然后这个分支的所有元素加入到集合res中
        if (index >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            //如果当前截取的子串不是回文的，就跳过
            if (!isPalindrome2(s, index, i)){
                continue;
            }
            //做出选择
            cur.add(s.substring(index, i + 1));
            //递归
            backTrack(s, i + 1, res, cur);
            //撤销选择
            cur.remove(cur.size() - 1);
        }
    }

    //判断字符串从[left，right]的子串是否是回文的
    public static boolean isPalindrome2(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        return true;
    }




    ///////////////////////////////////////////////////////////////////////
    // https://blog.csdn.net/zjg379569986/article/details/102505694
    /**
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition3(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(res,list,s,0);
        return res;
    }

    /**
     *
     * @param res
     * @param list
     * @param s
     * @param index
     */
    public static void dfs(List<List<String>> res,List<String> list,String s,int index) {

        //已经到了字符串的结尾了，把结果集放到最终解中
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        //不断取更长的头串
        for (int i = index;i < s.length();i++) {
            if (isPartition(s,index,i)) {//判断头串是否是回文
                String temp = s.substring(index,i+1);
                list.add(temp);
                //对后面的字符串进行递归，进行相同的处理
                dfs(res,list,s,i+1);
                //删除结尾已有结果，回到上一层（回溯的精髓）
                list.remove(list.size()-1);
            }
        }

    }

    /**
     * 判断字符串的某一段是否是回文
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean isPartition(String s,int start,int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
