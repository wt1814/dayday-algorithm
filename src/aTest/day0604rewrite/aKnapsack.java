package aTest.day0604rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: aKnapsack
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/4/21 10:36 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
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
     * @param wupin
     * @param syrl
     * @param rongliang
     * @param price
     * @return
     */
    public static int knapsack(int wupin,int syrl,int[] rongliang,int[] price ){

        int[][] dp = new int[wupin+1][syrl+1];
        for (int i=1;i<=wupin;i++){
            for (int w=1;w<=syrl;w++){

                if (w-rongliang[i-1]<0){
                    dp[i][w] = dp[i-1][w];
                }else {
                    //dp[i][w] = Math.max(dp[i-1][w-rongliang[i-1]]+price[i-1],dp[i-1][w]);
                    dp[i][w] = Math.max(
                            // 把第i个物品装进背包
                            dp[i-1][w-rongliang[i-1]] + price[i-1],
                            // 不把第i个物品装进背包
                            dp[i-1][w]
                    );
                }
            }

        }

        return dp[wupin][syrl];


    }
}
