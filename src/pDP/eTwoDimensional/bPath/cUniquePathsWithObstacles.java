package pDP.eTwoDimensional.bPath;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * todo 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class cUniquePathsWithObstacles {

    public static void main(String[] args) {

    }

    ////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/LuPz-OL-hQpQtns81sB_AA
    // 如果当前行没有障碍物，那么当前行的值都是1，如果有障碍物，那么第一个障碍物前面都是1，其他的都是0。
    /**
     * 一种是当前网格没有障碍物，一种是当前网格有障碍物。
     * 1，如果当前网格dp[i][j]有障碍物，那么这里肯定是走不过去的，所以dp[i][j]=0。
     * 2，如果当前网格dp[i][j]没有障碍物，那么递推公式就和上一题409，动态规划求不同路径一样了。
     * 因为只能从上面或左边走过来，所以递推公式是 dp[i][j]=dp[i-1][j]+dp[i][j-1]。
     *     dp[i-1][j]表示的是从上面走过来的路径条数。
     *     dp[i][j-1]表示的是从左边走过来的路径条数。
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        //第一列初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }
            else{
                break;
            }
        }
        //第一行初始化
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }
            else{
                break;
            }
        }

        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }


    ////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485089&idx=1&sn=fd52fd088a5778c9ee101741d458605d&chksm=fd9cadbecaeb24a8f2115139f438fed36cddd96d00d5249d661684faf33b9874e62883720ae6&scene=178&cur_album_id=1773144264147812354#rd

}
