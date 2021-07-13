package lDP.cScene;

/**
 * 01背包
 * 容量为W的背包和N个物品，其中第i个物品的重量为wt[i]，价值为val[i]
 */
public class aKnapsack {


    public static void main(String[] args){

        int N = 3;
        int W = 4;
        int[] wt = {2,1,3};
        int[] val = {4,2,3};
        System.out.println(knapsack(N,W,wt,val));
    }

    /**
     *
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

                if (w-wt[i-1] < 0){
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
