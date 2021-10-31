package pDP.eTwoDimensional.bPath;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 */
public class bUniquePaths {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485037&idx=1&sn=d6d52c48600e655161e84f25d3402514&chksm=fd9cad72caeb2464e1d8adcd991ec178001472a6c6ddc02a1764bc74ea27a97f71fddbce9975&scene=178&cur_album_id=1773144264147812354#rd
    // https://mp.weixin.qq.com/s/r4HL95JeeUgWR_c6dEsvGw
    /**
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        //第一列都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行都是1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        /**
         * todo 因为只能从上面或左边走过来，所以递推公式是
         * dp[i][j]=dp[i-1][j]+dp[i][j-1]。
         *
         * dp[i-1][j]表示的是从上面走过来的路径条数。
         * dp[i][j-1]表示的是从左边走过来的路径条数。
         */
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    // todo 时间复杂度：O(n*m)
    // todo 空间复杂度：O(n*m)

}
