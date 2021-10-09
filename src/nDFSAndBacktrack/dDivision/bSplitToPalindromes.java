package nDFSAndBacktrack.dDivision;

import java.util.ArrayList;
import java.util.List;

/**
 * 551，回溯算法解分割回文串
 */
public class bSplitToPalindromes {

    // *** https://mp.weixin.qq.com/s/SrBfADlsOXjeOX4Cr4pQNg
    // https://leetcode-cn.com/problems/palindrome-partitioning/
    // https://blog.csdn.net/zjg379569986/article/details/102505694
    // https://programmercarl.com/0131.%E5%88%86%E5%89%B2%E5%9B%9E%E6%96%87%E4%B8%B2.html#%E6%80%BB%E7%BB%93
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247491154&idx=1&sn=de5214414d1e122530c67e035be7cef4&chksm=fb418d72cc360464a835ba9ec4f7b7f1f9f998245bfcd901c9af29fd072f153519305540d9a9&scene=21#wechat_redirect

    public static void main(String[] args) {

        String s = "aabb";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }

    /**
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
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
