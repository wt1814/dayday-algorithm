package nDFSAndBacktrack.dDivision;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 140. 回溯算法和DFS解单词拆分 II
 *
 * 字符串拆分
 */
public class aWordBreak {

    // todo 动态规划解单词拆分 https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247491645&idx=1&sn=456bb5dd519be3fafa1bcb08d73d8944&chksm=fb42731dcc35fa0bf914ae98e51a26e6a6c5d2b8c77a90dc1abde6625daeaa6cacb3b2376bdc&scene=21#wechat_redirect
    // DFS和BFS解单词拆分 https://mp.weixin.qq.com/s/56oHSdHC9GxG4-_s-1Pybw
    // https://mp.weixin.qq.com/s/ErnPAEebOCnwmqkIBUeOZA

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);

    }

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
            //如果截取的子串在字典中，继续剩下的拆分，如果剩下的可以拆分成
            //在字典中出现的单词，直接返回true，如果不能则继续
            //截取更大的子串判断
            if (dfs(s, wordDict, i)){
                return true;
            }
        }
        return false;

    }

}
