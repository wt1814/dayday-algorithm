package pDP.eTwoDimensional.cMatrix;

/**
 * 221. 给定一个二维的 0-1 矩阵，求全由 1 构成的最大正方形面积。
 */
public class eMaximalSquare {

    public static void main(String[] args) {

    }

    ///////////////////////////////////////////////////////////
    public static int maximalSquare1(char[][] matrix) {

        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // todo 如果该位置的值是 111，则 dp(i,j)\textit{dp}(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp\textit{dp}dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 111
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    ///////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/nSQbgqcngC4KEA-GJb-o9Q
    public static int maximalSquare(char[][] matrix) {

        //二维矩阵的宽和高
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height + 1][width + 1];

        int maxSide = 0;//最大正方形的宽
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    //递推公式
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    //记录最大的边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        //返回正方形的面积
        return maxSide * maxSide;

    }


}
