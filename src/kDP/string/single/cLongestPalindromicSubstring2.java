package kDP.string.single;

/**
 * 最长回文子串
 * todo 自己写的
 */
public class cLongestPalindromicSubstring2 {

    public static void main(String[] args){
        String str = "abc1234321ab";
        System.out.println(isHuiWen(str.toCharArray(),3,9));
        lis("abc1234321ab");
    }

    public static String lis (String str){

        if (str == null || str.length() == 0){
            return "";
        }

        char[] chars = str.toCharArray();
        boolean[][] dp = getdp(chars);
        String result = generateLIS(chars,dp);
        return result;
    }

    /**
     * 构造dp数组
     * @param chars
     * @return
     */
    private static boolean[][] getdp(char[] chars) {

        // dp数组
        boolean[][] dp = new boolean[chars.length][chars.length];
        // base case
        for (int i =0;i< dp.length;i++){
            dp[i][i] = true;
        }
        //todo 状态转移方程 需要优化
        for (int i = 0;i<dp.length;i++){
            for (int j = i;j< dp.length;j++){
                if (isHuiWen(chars,i,j)){
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }

    /**
     *
     * @param chars
     * @param dp
     * @return
     */
    private static String generateLIS(char[] chars, boolean[][] dp) {
        int start = 0;
        int end = 0;

        int maxCha = 0;
        int startTemp = 0;

        for (int i =0;i<dp.length;i++){
            for (int j=0;j<dp[i].length;j++){
                if (dp[i][j]){



                    start = i;
                    end = j;
                    if (j-i+1 > maxCha){
                        maxCha = j-i+1;
                        startTemp = start;
                    }
                }
            }
        }
        System.out.println(maxCha);

        return "";
    }


    /**
     * 判断是否回文串
     * @param chars
     * @return
     */
    private static boolean isHuiWen(char[] chars,int left,int right){

        boolean result = true;

        if (chars.length == 1){
            return result;
        }

/*        int left = 0;
        int right = chars.length-1;*/

        while (left < right){
            if (chars[left] != chars[right]){
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;
    }

}
