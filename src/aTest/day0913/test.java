package aTest.day0913;

import java.util.ArrayList;
import java.util.List;

public class test {


    public static void main(String[] args) {

        String s = "aabb";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }



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
