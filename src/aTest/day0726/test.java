package aTest.day0726;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/26/21 11:05 AM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {

    public long subsequence (int n, int[] array) {
        // write code here

        long result = Long.MIN_VALUE;

        if (array.length == 0){
            return result;
        }else if(array.length == 1){
            return array[0];
        }else if(array.length == 2){
            return Long.max(array[0],array[1]);
        }


        int[] dp = new int[array.length];
        for (int i=0;i<dp.length;i++){
            dp[i] = 0;
        }



        return result;

    }


}
