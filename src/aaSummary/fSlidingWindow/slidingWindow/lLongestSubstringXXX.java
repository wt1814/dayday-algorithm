package aaSummary.fSlidingWindow.slidingWindow;

import java.util.Arrays;

/**
 * 395. 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。
 * 返回这一子串的长度。
 *
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 */
public class lLongestSubstringXXX {


    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484728&idx=1&sn=c72b71bc0b6fce4cf29ca756a8a4eb36&chksm=fd9cae27caeb2731b785e76ae1966688f6a6661977916e25926a357117b7932caa3b51815361&scene=178&cur_album_id=1748659352518868992#rd
    /**
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (int p = 1; p <= 26; p++) {
            Arrays.fill(cnt, 0);
            // tot 代表 [j, i] 区间所有的字符种类数量；sum 代表满足「出现次数不少于 k」的字符种类数量
            for (int i = 0, j = 0, tot = 0, sum = 0; i < n; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                // 如果添加到 cnt 之后为 1，说明字符总数 +1
                if (cnt[u] == 1) {
                    tot++;
                }
                // 如果添加到 cnt 之后等于 k，说明该字符从不达标变为达标，达标数量 + 1
                if (cnt[u] == k) {
                    sum++;
                }
                // 当区间所包含的字符种类数量 tot 超过了当前限定的数量 p，那么我们要删除掉一些字母，即「左指针」右移
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    // 如果添加到 cnt 之后为 0，说明字符总数-1
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    // 如果添加到 cnt 之后等于 k - 1，说明该字符从达标变为不达标，达标数量 - 1
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                // 当所有字符都符合要求，更新答案
                if (tot == sum) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        return ans;
    }

}
