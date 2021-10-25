package fSlidingWindow.slidingWindow.twoArray;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/solution/leetcode-offer-hua-dong-chuang-kou-miao-o6wzy/
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 */
public class dCheckInclusion {

    public static void main(String[] args) {

    }

    // todo https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=21#wechat_redirect
    // valid变量表示窗口中满足need条件的字符个数，如果valid和need.size的大小相同，则说明窗口已满足条件，已经完全覆盖了串T。

    //////////////////////////////
    public static boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) {
            return false;
        }

        // 记录 s1 中的字符及其对应的个数
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < s1.length(); i ++){
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        // 表示窗口中满足 need 条件的字符个数
        int vaild = 0;

        while (right < s2.length()) {
            char newChar = s2.charAt(right);
            // 扩大窗口
            right ++;
            // 如果该字符存在于字符串 s1 中，则更新窗口数据以及 vaild (不存在的话没有更新的必要)
            if (need.containsKey(newChar)) {
                window.put(newChar, window.getOrDefault(newChar, 0) + 1);
                // 若窗口中的该字符满足 need 条件，则 vaild ++
                if (window.get(newChar).equals(need.get(newChar))) {
                    vaild ++;
                }
            }

            // 窗口中的字符数量等于 need 的大小(s1 中不同字符的个数), 则收缩窗口
            while (right - left == s1.length()) {
                if (vaild == need.size()) {
                    return true;
                }

                // 收缩窗口
                char removeChar = s2.charAt(left);
                left ++;

                // 如果被移除掉的字符存在于字符串 s1 中，则更新窗口数据以及 vaild (不存在的话没有更新的必要)
                if (need.containsKey(removeChar)) {
                    if (window.get(removeChar).equals(need.get(removeChar))) {
                        vaild --;
                    }
                    window.put(removeChar, window.get(removeChar) - 1);
                }
            }
        }

        return false;
    }


}
