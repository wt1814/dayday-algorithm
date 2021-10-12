package fSlidingWindow.slidingWindow.twoArray;

/**
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 */
public class cEqualSubstring {

    // https://www.cnblogs.com/huansky/p/13488234.html
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right =0;
        int sum = 0;
        int res = 0;
        // 构造窗口
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            right++;
            // 窗口构造完成，这时候要根据条件当前的窗口调整窗口大小
            while (sum > maxCost) {
                sum -=  Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            // 记录此时窗口的大小
            res = Math.max(res, right -left);
        }
        return res;
    }



    // https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/jin-ke-neng-shi-zi-fu-chuan-xiang-deng-b-higz/
    public int equalSubstring1(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }


}
