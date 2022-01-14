package pDP.eTwoDimensional.bPath;

/**
 * 931. 下降路径最小和
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * todo 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 示例 1：
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗+斜体标注：
 * [[2,1,3],      [[2,1,3],
 *  [6,5,4],       [6,5,4],
 *  [7,8,9]]       [7,8,9]]
 */
public class gMinFallingPathSum {


    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485163&idx=1&sn=ffe456777bcda52c036e6eb2181d1932&chksm=fd9cadf4caeb24e21a57ce47295a54ee9d591dfbb857549a57c145cdeeabf8c4324b007fc18b&scene=178&cur_album_id=1773144264147812354#rd
    int MAX = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] mat) {

        int n = mat.length;
        int ans = MAX;
        // 枚举首行的每个下标作为「起点」
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, find(mat, i));
        }
        return ans;

    }

    // 返回以 (0, u) 作为起点的最小路径和
    int find(int[][] mat, int u) {

        int n = mat.length;
        int[][] f = new int[n][n];

        for (int i = 0; i < n; i++) {
            f[0][i] = i == u ? mat[0][i] : MAX;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = MAX;
                int val = mat[i][j];
                if (f[i-1][j] != MAX) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j] + val);
                }
                if (j - 1 >= 0 && f[i-1][j-1] != MAX) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + val);
                }
                if (j + 1 < n  && f[i-1][j+1] != MAX) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j+1] + val);
                }
            }
        }
        int ans = MAX;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n-1][i]);
        }
        return ans;

    }

}
