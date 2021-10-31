package pDP.eTwoDimensional.bPath;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class fMinimumTotal {

    public static void main(String[] args) {

    }


    ///////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485123&idx=1&sn=8a427e56d472d1517b0983d8cdc5c629&chksm=fd9caddccaeb24caea7a272ddaf11d9bd476d4af710d0581c4b12223a11dd6edf33091006731&scene=178&cur_album_id=1773144264147812354#rd
    public static int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int ans = Integer.MAX_VALUE;

        int[][] f = new int[n][n];

        f[0][0] = tri.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = tri.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                if (j != i) f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n - 1][i]);
        }
        return ans;
    }

    ////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/osILrlqPtvfg1G-2GySjHw


}
