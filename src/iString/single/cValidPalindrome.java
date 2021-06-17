package iString.single;

/**
 * 验证回文串
 */
public class cValidPalindrome {

    // 反转字符串。如果是回文串，则它的反转字符串等于它本身

    // 双指针


    /**
     *
     * @param chars 原始字符串的字符数组
     * @param left
     * @param right
     * @return 回文串的长度
     */
    private int expandAoundCenter(char[] chars,int left,int right){

        // 当 left = right 的时候，回文中心是一个字符串，回文串的长度是奇数
        // 当 right = left+1 的时候，此时回文中心是两个字符串，回文串的长度是偶数
        int len = chars.length;
        int i = left;
        int j = right;

        while (i >= 0 && j < len){
            if (chars[i] == chars[j]){
                i--;
                j++;
            }else {
                break;
            }
        }

        // 跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，
        // 回文串的长度时 j-i+1-2 = j-i-1
        return j-i-1;
    }
}
