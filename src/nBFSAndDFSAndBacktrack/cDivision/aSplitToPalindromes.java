package nBFSAndDFSAndBacktrack.cDivision;


import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class aSplitToPalindromes {


    // https://leetcode-cn.com/problems/palindrome-partitioning/

    // https://blog.csdn.net/zjg379569986/article/details/102505694


    String s;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        this.s = s;
        List<String> list = new ArrayList<>();
        dfs(list,0);
        return res;
    }
    public void dfs(List<String> list,int index) {
        //已经到了字符串的结尾了，把结果集放到最终解中
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        //不断取更长的头串
        for (int i = index;i < s.length();i++) {
            if (isPartition(index,i)) {//判断头串是否是回文
                String temp = s.substring(index,i+1);
                list.add(temp);
                //对后面的字符串进行递归，进行相同的处理
                dfs(list,i+1);
                //删除结尾已有结果，回到上一层（回溯的精髓）
                list.remove(list.size()-1);
            }
        }
    }
    //判断字符串的某一段是否是回文
    public boolean isPartition(int start,int end) {
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
