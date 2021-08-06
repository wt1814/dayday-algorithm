package aTest.day0807;

public class test {

    public static void main(String[] args){
        int[] array = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        long subsequence = subsequence(6, array);
        System.out.println(subsequence);
    }

    public static long subsequence (int n, int[] array) {
        // write code here
        int len = array.length;
        if(len == 0){
            return -1;
        }

        long[] dp = getDp(array);
        long result = dp[0];
        for(int i = 0;i<dp.length;i++){
            if(dp[i]> result){
                result = dp[i];
            }
        }

        return result;
    }

    public static long[] getDp(int[] array){

        long[] result = new long[array.length];
        result[0] = array[0];
        if(array.length>1){
            result[1] = Math.max(array[0],array[1]);
        }

        int i = 2;
        while(i<array.length){
            if(array[i]>0){
                result[i] = result[i-2]+array[i];
            }else{
                result[i] = result[i-1];
            }
            i++;
        }

        return result;
    }
}
