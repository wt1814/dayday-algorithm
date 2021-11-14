package pDP.bKnapsack.a01Knapsack;

/**
 * 01背包
 * 容量为W的背包和N个物品，其中第i个物品的重量为wt[i]，价值为val[i]
 * todo 「01背包」是指给定物品价值与体积（对应了「给定价值与成本」），在规定容量下（对应了「限定决策规则」）如何使得所选物品的总价值最大。
 */
public class aKnappsack {

    public static void main(String[] args){

        int N = 3;
        int W = 4;
        int[] wt = {2,1,3};
        int[] val = {4,2,3};
        System.out.println(knapsack(N,W,wt,val));
        
    }

    // todo 理解：https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485638&idx=1&sn=d7468955c5b121664031fd5c1b5a6f10&scene=21#wechat_redirect

    /////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/RXfnhSpVBmVneQjDSUSAVQ
    /**
     * todo 找状态，定义dp数组
     * 其中 和 对应了输入的「物品体积」和「物品价值」，属于不变参数，无须考虑。
     * 而 和 分别代表「当前枚举到哪件物品」和「现在的剩余容量」。
     * 返回值则是我们问题的答案：最大价值。
     * 那么根据变化参数和返回值，可以抽象出我们的 dp 数组：
     * 一个二维数组，其中一维代表当前「当前枚举到哪件物品」，另外一维「现在的剩余容量」，数组装的是「最大价值」。
     * @param N 状态一：背包剩余的容量
     * @param W 状态二：可选择的物品还有哪些
     * @param wt
     * @param val
     * @return
     */
    public static int knapsack(int N,int W,int[] wt,int[] val){

        // dp数组 对于前i个物品，当背包当容量为w时，可以装当最大价值是dp[i][w]
        int[][] dp = new int[N+1][W+1];
        // base case 已初始化

        for (int i =1; i<=N; i++){
            for (int w = 1; w<=W;w++){
/*                int p1 = dp[i][w];
                int p2 = dp[i-1][w-wt[i-1]] + val[i-1];*/

                if (w-wt[i-1] < 0){ //todo 背包剩余容量不足
                    // 这种情况下只能选择不装如背包
                    dp[i][w] = dp[i-1][w];  //todo i-1 索引偏移
                }else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            // 把第i个物品装进背包
                            dp[i-1][w-wt[i-1]] + val[i-1],
                            // 不把第i个物品装进背包
                            dp[i-1][w]
                    );
                }
            }
        }
        return dp[N][W]; //todo 返回右下角的值
    }


}
