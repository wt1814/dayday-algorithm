package jString.two;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {


    public static void main(String[] args){
        String[] arr = {"baaa","baab","baac","abaa"};
        System.out.println(longestCommonPrefix(arr));
        //System.out.println(longestCommontPrefix6(arr));

    }

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

    //////////////////////////////////////////////////////////////////////////

    /**
     * 利用二分法的思想
     * @param strs
     * @return
     */
    public static String longestCommontPrefix6(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for(String str : strs) {
            min = Math.min(min, str.length());
        }
        int low = 1;
        int high = min;
        while(low <= high) {
            int middle = (low + high)/2;
            if(isCommontPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high)/2);
    }

    /**
     *
     * @param strs
     * @param length
     * @return
     */
    public static boolean isCommontPrefix(String[] strs, int length) {
        String tmp = strs[0].substring(0, length);
        for (int i=0; i<strs.length; i++) {
            if(!strs[i].startsWith(tmp)) {
                return false;
            }
        }
        return true;
    }


}
