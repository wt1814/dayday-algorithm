package pDP.bCombinate.bKnapsack.bCompletelyKnapsack;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class cCoinChange {

    public static void main(String[] args) {

    }


    ////////////////////////////////////////////////////////////////////
    // https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
    public int minMoney (int[] arr, int aim) {

        // write code here
        int[] dp = new int[aim + 1];//dp[i]的含义是目标值为i的时候最少钱币数是多少。

        dp[0] = 0;//总金额为0的时候所需钱币数一定是0
        int Max = aim + 1;//定一个全局最大值
        Arrays.fill(dp,Max);//把dp数组全部定为最大值

        for(int i = 1;i <= aim;i ++){// 遍历目标值
            for(int j = 0;j < arr.length;j ++){// 遍历钱币
                if(arr[j] <= i){//如果当前的钱币比目标值小就可以兑换
                    dp[i] = Math.min(dp[i],dp[i-arr[j]] + 1);
                }
            }
        }

        return dp[aim] > aim ? -1 : dp[aim];

    }


    ///////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486435&idx=1&sn=2464b01e9c0fb8d81fcea6dd4ed0ec92&chksm=fd9ca0fccaeb29ea9947456290099143c5bc9bdea0ccfb2408f5fd63f5e0fc13fcd8060d4251&token=646498266&lang=zh_CN&scene=21#wechat_redirect
    /**
     *
     * @param cs
     * @param cnt
     * @return
     */
    public static int coinChange(int[] cs, int cnt) {

        int INF = Integer.MAX_VALUE;
        int n = cs.length;
        int[][] f = new int[n + 1][cnt + 1];

        // 初始化（没有任何硬币的情况）：只有 f[0][0] = 0；其余情况均为无效值。
        // 这是由「状态定义」决定的，当不考虑任何硬币的时候，只能凑出总和为 0 的方案，所使用的硬币数量为 0
        for (int i = 1; i <= cnt; i++) {
            f[0][i] = Integer.MAX_VALUE;
        }

        // 有硬币的情况
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = 0; j <= cnt; j++) {
                // 不考虑当前硬币的情况
                f[i][j] = f[i - 1][j];

                // 考虑当前硬币的情况（可选当前硬币个数基于当前容量大小）
                for (int k = 1; k * val <= j; k++) {
                    if (f[i - 1][j - k * val] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-k*val] + k);
                    }
                }
            }
        }
        return f[n][cnt] == INF ? -1 : f[n][cnt];

    }


    //////////////////
/*    在本题中，构造这样二维动态规划表，dp[i][j]，其中，i j的含义如下：

    i: 代表可以使用的货币种类为 arr[0..i]
    j: 代表需要兑换的面值数，其取值范围为[0..aim]，因此实现时，二维数组的列数应该为aim + 1

            1. 构造过程：

    构造边界值。边界值是更新规划表的起始值，也是很容易犯错的地方，需要谨慎设置起始边界值。
    dp[0..N-1][0]：规划表的第一列值，表示当需要兑换0元时，需要的货币数，显然货币数为0，直接设置为0.
            dp[0][0..aim]：规划表的第一行值，表示只使用arr[0]一种货币兑换[0..aim]时，需要的货币数，因此，只要tmp_aim可以被arr[0]整除，返回整除后的数，即为对应的值。在下面的实现中，我们使用了更为通用的方法来得到规划表的第一行的值，可以根据下面的算法，理解一下实现中的计算方法。

            2. 更新动态规划表
    更新方向：逐行更新，每行从左到右更新。
    更新值：对于dp[i][j]，更新的依据有两个值，一个是“不使用当前种类的货币时，组成总数的j的最小方法，即dp[i-1][j]”，另外一个是“使用并且仅使用一张当前种类的货币时，组成总数的j的最小方法，即 dp[i][j-arr[i]] + 1”，取这两个值中的最小值即为dp[i][j]的值。
    关于依据中的第二个值，可以通过公式推导得到。可以查看文末的参考资料详细了解。*/


/*    典型的动态规划问题，如果输入值为一个以上，可以考虑使用二维数组。
输入值为面值数组 arr 和找零数 aim，所以我们可以创建一个二维数组 dp[m][n]，纵轴 m 表示所有面值，横轴 n 表示使用面值 m 支付时剩余零钱数。
    动态规划的问题需在解题之前明确阶段、状态、边界。每个阶段的任务都会推进状态的更新，最后到达边界时解决问题。本题中每个阶段的任务是“若当前剩余需找零数为 m 时，考虑是否使用一张当前面值的钱”，状态记录每个阶段任务计算出的数据，即本题中的使用货币的最小张数。数组从左上角开始计算，到右下角结束，所以边界为遍历完数组。
            “若当前剩余需找零数为 m 时，考虑是否使用一张当前面值的钱”是指当使用一张当前面值的货币，那么使用的货币数 +1 且剩余需找零数要减去当前货币面值，若不考虑使用当前面值的货币，那么货币数为使用上一种类的货币的数量且剩余找零数不需要减去。选出两种方法之中货币数最少的那一个就是最优解。
    初始化第一种面值的数量 dp[0][?] = 剩余找零 / 当前面值，如果有余数则设为 0。
    在 (3) 中描述的两种方法，如果最少货币数为 0 则不取*/

    public int minMoney2 (int[] arr, int aim) {

        // 二维数组 dp[m][n], m 表示货币种类, n表示剩余找零
        int[][] dp = new int[arr.length][aim + 1];
        // 初始化第一种面值，若能被剩余找零整除，就在数组中填该货币使用的张数。
        for (int i = 1; i < aim + 1; ++i) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            }
        }

        for (int m = 1; m < arr.length; ++m) {
            for (int n = 1; n < aim + 1; ++n) {
                // 若当前面值大于剩余找零，则只能不使用此种货币
                if (arr[m] > n) {
                    dp[m][n] = dp[m - 1][n];
                } else if (arr[m] == n) {
                    dp[m][n] = 1;
                } else if (dp[m][n - arr[m]] != 0 &&  dp[m - 1][n] != 0) {
                    // 若使用一张当前货币和不使用当前货币都有值，取最小那个
                    dp[m][n] = Math.min(dp[m][n - arr[m]] + 1, dp[m - 1][n]);
                } else {
                    // 若其中一个为 0，取不为 0 的那一个
                    dp[m][n] = dp[m][n - arr[m]] != 0 ? dp[m][n - arr[m]] + 1 : dp[m - 1][n];
                }

            }
        }
        return dp[arr.length-1][aim] == 0 ? -1 : dp[arr.length-1][aim];
    }


}

