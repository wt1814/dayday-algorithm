package pDP.eTwoDimensional.cMatrix;

/**
 * 1277. 统计全为 1 的正方形子矩阵   正方形的个数
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 * 示例 1：
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 */
public class fCountSquares {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/QehNMzsisC9ZAPZyxCGBzw
    /**
     *
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {
        int count = 0;//正方形的个数
        // dp[i][j]表示的是在矩阵中以坐标(i,j)为右下角的最大正方形边长
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //如果当前坐标是0，就不可能构成正方形，直接跳过
                if (matrix[i][j] == 0){
                    continue;
                }
                //递推公式
                dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                //累加所有的dp值
                count += dp[i + 1][j + 1];
            }
        }
        return count;
    }

}
