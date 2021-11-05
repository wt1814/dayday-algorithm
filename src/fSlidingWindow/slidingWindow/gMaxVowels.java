package fSlidingWindow.slidingWindow;

/**
 * todo 固定窗口
 * 1456. 定长子串中元音的最大数目
 * https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/solution/ding-chang-zi-chuan-zhong-yuan-yin-de-zu-4ka7/
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 * 示例 1：
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 */
public class gMaxVowels {


    public static void main(String[] args) {

    }

    // https://www.cnblogs.com/huansky/p/13488234.html
    /**
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k) {

        int right =0;
        int sum = 0;
        int max = 0;

        while (right < s.length()) { //todo 右指针
            sum += isYuan(s.charAt(right)) ;
            right++;
            if (right >=k) {
                max = Math.max(max, sum);
                sum -= isYuan(s.charAt(right-k));
            }
        }
        return max;

    }

    public static int isYuan(char s) {

        return s=='a' || s=='e' ||s=='i' ||s=='o' ||s=='u' ? 1:0;
    }

}
