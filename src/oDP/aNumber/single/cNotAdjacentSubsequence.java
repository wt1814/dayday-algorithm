package oDP.aNumber.single;

/**
 * 不相邻最大子序列和
 *
 * todo 错误写法
 *             if(array[i]>0){
 *                 result[i] = result[i-2]+array[i];
 *             }else{
 *                 result[i] = result[i-1];
 *             }
 *  todo 正确写法
 *  result[i] = Math.max(result[i-2]+array[i],result[i-1]);
 */
public class cNotAdjacentSubsequence {

    /**
     * 状态转移表达式：
     * (1)对于当前的元素arr[i]，如果取，那么dp[i] = dp[i-2] + arr[i]
     * (2)如果不取，那么dp[i] = dp[i-1]
     *
     * @param n
     * @param array
     * @return
     */
    public long subsequence (int n, int[] array) {
        // write code here
        //todo n+1，一维数组长度加1，设置哑节点
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = array[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + array[i-1]);
        }
        return dp[n];
    }


    //////////////////////////////////////////////////////////
    public long subsequence1 (int n, int[] array) {
        // write code here
        int len = array.length;
        if(len == 0){
            return -1;
        }

        long[] dp = getDp(array);
        long result = dp[0];
        for(int i = 0;i<dp.length;i++){
            if(dp[i]> result){
                result = dp[i];
            }
        }
        if(result<0){
            result = 0;
        }

        return result;
    }

    public long[] getDp(int[] array){

        long[] result = new long[array.length];
        result[0] = array[0];
        if(array.length>1){
            result[1] = Math.max(array[0],array[1]);
        }

        int i = 2;
        while(i<array.length){
            //todo 错误写法
/*
            if(array[i]>0){
                result[i] = result[i-2]+array[i];
            }else{
                result[i] = result[i-1];
            }
*/
            //todo 正确写法
            result[i] = Math.max(result[i-2]+array[i],result[i-1]);
            i++;
        }

        return result;
    }

}
