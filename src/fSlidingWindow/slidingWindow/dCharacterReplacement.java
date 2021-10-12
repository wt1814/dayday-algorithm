package fSlidingWindow.slidingWindow;

/**
 * 424. 双指针解替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 */
public class dCharacterReplacement {

    public static void main(String[] args) {
        int i = characterReplacement("ABAB", 2);
        System.out.println(i);
    }

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247490163&idx=1&sn=4cbb66581d85a6a31019e0a25e3da21a&chksm=fb418953cc3600454f3c0e765f6e1c860076b61d237471eaf72a98b6922ac9b7d2b36b6a2b3c&scene=21#wechat_redirect
    /**
     * 在一个窗口内假如出现次数最多的那个字符出现的次数是a，窗口的长度是b，
     * todo 只要满足a+k>=b，就可以把窗口中的其他字符全部替换为出现次数最多的那个字符。
     * 比如在窗口中有字符串"ABAABAB"，如果k大于等于3，就可以把字符串中的所有字符B替换为A。
     * todo 相反如果a+k<b，是没法把窗口内的其他字符全部替换为出现次数最多的那个字符。
     * 比如字符串"ABAABBA"，如果k小于3，我们是不能把字符串中的所有字符B全部替换为A的。
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        //字符串的长度
        int length = s.length();
        //用来存放对应字母的个数，比如字母A的个数是map[0],
        //字母B的个数是map[1]……
        int[] map = new int[26];
        int left = 0;//窗口左边的位置
        //窗口内曾经出现过相同字母最多的数量
        int maxSameCount = 0;
        int right = 0;//窗口右边的位置
        //满足条件的最大窗口，也就是可以替换的最长子串的长度
        int maxWindow = 0;
        //窗口的左边先不动，移动右边的位置
        for (; right < length; right++) {  // todo for循环的使用
            //统计窗口内曾经出现过相同字母最多的数量
            maxSameCount = Math.max(maxSameCount, ++map[s.charAt(right) - 'A']);
            //如果相同字母最多的数量加上k还小于窗口的大小，说明其他的字母不能全部替换为
            //最多的那个字母，我们要缩小窗口的大小，顺便减去窗口左边那个字母的数量，
            //因为他被移除窗口了，所以数量要减去
            if (k + maxSameCount < right - left + 1) {
                map[s.charAt(left) - 'A']--;
                left++;
            } else {//满足条件，要记录下最大的窗口，
                maxWindow = Math.max(maxWindow, right - left + 1);
            }
        }
        return maxWindow;
    }

}
