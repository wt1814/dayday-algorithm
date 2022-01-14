package pDP.eTwoDimensional.bPath;

/**
 * 1575. 统计所有可行路径
 * https://leetcode-cn.com/problems/count-all-possible-routes/
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * 每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 * 请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 * 请你返回从 start 到 finish 所有可能路径的数目。
 * 由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 *
 * 示例 1：
 * 输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * 输出：4
 * 解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
 * 1 -> 3
 * 1 -> 2 -> 3
 * 1 -> 4 -> 3
 * 1 -> 4 -> 2 -> 3
 */
public class iCountRoutes {

    public static void main(String[] args) {

    }

    // 记忆化搜索： https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485297&idx=1&sn=5ee4ce31c42d368af0653f60aa263c82&chksm=fd9cac6ecaeb25787e6da90423c5467e1679da0a8aaf1a3445475199a8f148d8629e851fea57&scene=178&cur_album_id=1773144264147812354#rd
    // 动态规划： https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485319&idx=1&sn=95a3dc9c97ca57185de792ca70924afe&chksm=fd9cac98caeb258ebea466f59378670a90af1cb3015ae70922e1d04ac711a5b8d8d853ac5e7d&scene=178&cur_album_id=1773144264147812354#rd
    static int mod = 1000000007;
    public static int countRoutes(int[] ls, int start, int end, int fuel) {
        int n = ls.length;

        // f[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
        int[][] f = new int[n][fuel + 1];

        // 对于本身位置就在目的地的状态，路径数为 1
        for (int i = 0; i <= fuel; i++) {
            f[end][i] = 1;
        }

        // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
        // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
        // 其中 i 和 k 并无严格的大小关系
        // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
        // 因此需要先从小到大枚举油量
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(ls[i] - ls[k]);
                        if (cur >= need) {
                            f[i][cur] += f[k][cur-need];
                            f[i][cur] %= mod;
                        }
                    }
                }
            }
        }

        return f[start][fuel];

    }

}
