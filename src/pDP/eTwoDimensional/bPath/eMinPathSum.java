package pDP.eTwoDimensional.bPath;

/**
 * 64. 矩阵的最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class eMinPathSum {

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        int i = minPathSum(matrix);
        System.out.println(i);
    }

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485106&idx=1&sn=39adbde98707dc02a99e71f58cad5e7c&chksm=fd9cadadcaeb24bb2295d170f3de8dca0ce8e5acadccafbee82139dfe38ce1984435cd7a50ed&scene=178&cur_album_id=1773144264147812354#rd


    //////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/SqNdZOu9vSMNQx37EkousQ
    /**
     *
     * @param matrix
     * @return
     */
    public static int minPathSum (int[][] matrix) {

        int[][]  dp = new int[matrix.length][matrix[0].length];

        dp[0][0] = matrix[0][0];

        // 第一行 只能从左往右  第一个元素 的值为 原数组的第一个元素 dp[0][0] = a[0][0]  dp[0][j] = a[0][j] + dp[0][j-1];
        for(int i =1; i< matrix.length; i++) {
            dp[i][0] =  dp[i-1][0] + matrix[i][0];
        }
        // 第一列元素 只能从上往下 dp[i][0] = dp[i-1][0] + a[i][0]
        for(int i =1; i< matrix[0].length; i++) {
            dp[0][i] =  dp[0][i-1] + matrix[0][i];
        }

        // 第二行第二列元素的可能从 当前节点的左节点 和上节点过来 那么该节点的最小值应为 当前节点的值 加上 min （ 上节点 左节点）dp[i][j] = a[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];

    }

}
