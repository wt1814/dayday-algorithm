package aaSummary.fString.two;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 * // todo XXXX
 */
public class LongestCommonPrefix {


    public static void main(String[] args){
        String[] arr = {"baaa","baab","baac","abaa"};
        System.out.println(longestCommonPrefix(arr));
        //System.out.println(longestCommontPrefix6(arr));

    }

    ////////////////////////////todo 二分///////////////////////////////////////
    // https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }


    ///////////////////////////////////////////////////////
    // https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix (String[] strs) {
        // write code here
        String result = "";

        if(strs.length == 0){
            return result;
        }else if(strs.length == 1){
            return strs[0];
        }

        result = strs[0];
        for(int i = 1;i<strs.length;i++){ //todo 两两比较
            result = longestCommonPrefix(result,strs[i]);
        }
        return result;
    }

    /**
     * 计算两个字符的公共前缀
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonPrefix (String str1,String str2) {
        String result = "";
        int length = Math.min(str1.length(),str2.length());
        for(int i = 0;i<length;i++){
            if(str1.charAt(i) == str2.charAt(i)){
                result = str1.substring(0,i+1);
            }
        }
        System.out.println("result is "+ result);
        return result;
    }

}
