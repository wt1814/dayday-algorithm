package aTest.day0706;

public class test2 {

    public static void main(String[] args){
        double[] arr = {5.0,-0.5,-4.0};
        double v = maxProduct(arr);
        System.out.println(v);
    }

    public static double maxProduct(double[] arr) {

        double result = 0;
        if (arr.length ==0){
            return result;
        }

        double[] dp = new double[arr.length];

        for (int i = 0;i<arr.length;i++){
            if(i == 0){
                dp[0] = 1 * arr[i];
                continue;
            }
            if (dp[i-1] * arr[i] > arr[i]){
                dp[i] = dp[i-1] * arr[i];
            }else {
                dp[i] = arr[i];
            }
        }

        for (int i = 0;i<dp.length;i++){
            if (dp[i]>result){
                result = dp[i];
            }
        }
        return result;
    }
}
