package aaSummary.fSlidingWindow.slidingWindow;

import java.util.HashMap;

/**
 *  3. 双指针求无重复字符的最长子串
 *  给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *     输入: "abcabcbb"
 *     输出: 3
 *     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class bLengthOfLongestSubstring {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484130&idx=6&sn=6a6fd8a208ccd7f0b7d706a3ff5900d7&chksm=fd9ca9fdcaeb20eb43980e8c841294d8b366fdbc128dacf140a93740221691ba241fe4593501&scene=178&cur_album_id=1748659352518868992#rd
    // https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=21#wechat_redirect
    // todo https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487526&idx=1&sn=000b9cbf7db449c8ec7e09e26a911c2e&chksm=fb418306cc360a105d98b39290315f2b89744c9d7cbdb04b2262ef9bc5de77274d42f8b5afbe&scene=21#wechat_redirect
    /**
     * todo 双指针 + 哈希表（滑动窗口）
     * 最开始的时候两个指针i和j都指向第一个元素，然后i往后移，把扫描过的元素都放到map中，如果i扫描过的元素没有重复的，就顺便记录一下最大值max，如果i扫描过的元素有重复的，就改变j的位置，要保证j到i之间不能有重复的元素。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0){
            return 0;
        }

        int i = 0; int j = 0; // i，快指针；j，慢指针
        HashMap<Character, Integer> map = new HashMap<>(); // 哈希表
        int max = 0;

        for (; i < s.length(); ++i) {
            // todo todo todo 更新慢指针
            // 使用一个map来存储扫描过的元素，其中i指针是一直往右移动的，
            // 如果i指向的元素在map中出现过，说明出现了重复的元素，要更新j的值。
            // todo 并且这个j的值只能增大不能减小，也就是说j只能往右移动，不能往左移动，所以下面代码中j取的是重复元素位置的下一个值和j这两个值的最大值。
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
