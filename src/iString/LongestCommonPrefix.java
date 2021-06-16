package iString;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {


    public static void main(String[] args){
        String[] arr = {"baaa","baab","baac"};
        System.out.println(longestCommonPrefix(arr));
        System.out.println(longestCommontPrefix6(arr));

    }

    /**
     * 暴力递归解 "最长公共前缀"
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }

        // 求解最小字符串的长度
        String minLengthString = strs[0];
        int minlength = minLengthString.length();
        for(int i=1; i<strs.length; i++) {
            if(minlength>strs[i].length()){
                minLengthString = strs[i];
                minlength = strs[i].length();
            }
        }

        // 以最短字符串为基础求解最长公共前缀
        int index = minlength;
        String result = "";
        while(index>0){
            // 1. 计算 "最长公共前缀"
            String subString = minLengthString.substring(0, index);
            boolean isMax = true;
            for(int i=1; i<strs.length; i++){
                // 2. 遍历每个字符串判断是否包含 "最长公共前缀"
                if(strs[i].startsWith(subString) == false){
                    isMax = false;
                    break;
                }
            }
            if(isMax){
                result = subString;
                break;
            }
            index --;
        }
        return result;
    }


    //////////////////////////////////////////////////////////////

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
