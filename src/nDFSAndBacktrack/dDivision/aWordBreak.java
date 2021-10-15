package nDFSAndBacktrack.dDivision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 *     拆分时可以重复使用字典中的单词。
 *     你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 */
public class aWordBreak {

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);

    }

    ////////////////////////////////////////////////////
    // todo 动态规划解单词拆分 https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247491645&idx=1&sn=456bb5dd519be3fafa1bcb08d73d8944&chksm=fb42731dcc35fa0bf914ae98e51a26e6a6c5d2b8c77a90dc1abde6625daeaa6cacb3b2376bdc&scene=21#wechat_redirect
    // DFS和BFS解单词拆分 https://mp.weixin.qq.com/s/56oHSdHC9GxG4-_s-1Pybw
    /**
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s, wordDict, 0);
    }

    /**
     * start表示的是从字符串s的哪个位置开始
     * 每次截取一个子串，判断他是否存在于字典中，如果不存在于字典中，继续截取更长的子串……如果存在于字典中，然后递归拆分剩下的子串，这是一个递归的过程。
     * 因为是拆分，所以字符串截取的时候不能有重叠，那么[开始截取的位置]实际上就是上次截取位置的下一个。
     * @param s
     * @param wordDict
     * @param start
     * @return
     */
    public static boolean dfs(String s, List<String> wordDict, int start) {

        //字符串中的所有字符都遍历完了，也就是到叶子节点了，说明字符串s可以拆分成
        //在字典中出现的单词，直接返回true
        if (start == s.length()){
            return true;
        }
        //开始拆分字符串s，
        for (int i = start + 1; i <= s.length(); i++) {
            //如果截取的子串不在字典中，继续截取更大的子串\
            String substring = s.substring(start, i);
            if (!wordDict.contains(substring)){
                continue;
            }
            //如果截取的子串在字典中，继续剩下的拆分，
            // 如果剩下的可以拆分成在字典中出现的单词，直接返回true，
            // 如果不能则继续截取更大的子串判断
            if (dfs(s, wordDict, i)){
                return true;
            }
        }
        return false;

    }

    ///////////
    public boolean wordBreak1(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashSet<>(), 0);
    }

    //start表示的是从字符串s的哪个位置开始
    public boolean dfs(String s, List<String> wordDict, Set<Integer> indexSet, int start) {
        //字符串都拆分完了，返回true
        if (start == s.length())
            return true;
        for (int i = start + 1; i <= s.length(); i++) {
            //如果已经判断过了，就直接跳过，防止重复判断
            if (indexSet.contains(i))
                continue;
            //截取子串，判断是否是在字典中
            if (wordDict.contains(s.substring(start, i))) {
                if (dfs(s, wordDict, indexSet, i))
                    return true;
                //标记为已判断过
                indexSet.add(i);
            }
        }
        return false;
    }

}
