package fSlidingWindow.doublePointer;

import java.util.HashMap;

/**
 *  398，双指针求无重复字符的最长子串
 *  给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *     输入: "abcabcbb"
 *     输出: 3
 *     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class dLengthOfLongestSubstring {



    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487526&idx=1&sn=000b9cbf7db449c8ec7e09e26a911c2e&chksm=fb418306cc360a105d98b39290315f2b89744c9d7cbdb04b2262ef9bc5de77274d42f8b5afbe&scene=21#wechat_redirect

    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            //如果有重复的，就修改j的值
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            //记录查找的最大值
            max = Math.max(max, i - j + 1);
        }
        //返回最大值
        return max;
    }


}
