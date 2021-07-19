package aTest.day0714;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/19/21 2:52 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {

    public static void main(String[] args){
        int[] A = {3472,7789,7955,-7098,-9281,6101,5051,7778,3090,7423,-7151,5652,1595,-8094,677,-8324,8347,-2482,9313,-9338,-3157,8559,6945,3618,3087,121,-8468,3225,1356,6939,2799,-7231,-6309,-5453,633,-8689,-4776,2714,-2743,-1409,5918,-3333,1803,8330,-2206,-6117,-4486,-7903,-4375,-3739,2897,8056,-5864,-522,7451,-4541,-2813,5790,-532,-6517,925};

        System.out.println(solve(A));
    }

    public static long solve (int[] A) {
        // write code here
        if(A.length < 3){
            return -1;
        }
        Arrays.sort(A);
        long result = -1;
        int len = A.length;
        System.out.println(A[0]);
        System.out.println(A[1]);
        System.out.println(A[2]);

        System.out.println(A[len-3]);
        System.out.println(A[len-2]);
        System.out.println(A[len-1]);
        System.out.println("--------------");
        long result1 = (long)A[0] * A[1] * A[2];
        System.out.println(result1);
        long result2 = (long)A[0] * A[1] * A[len-1];
        System.out.println(result2);

        long result3 = (long)A[0] * A[len-2] * A[len-1];
        System.out.println(result3);

        long result4 = (long)A[len-3] * A[len-2] * A[len-1];
        System.out.println(result4);

        result = Math.max(Math.max(result1,result2),Math.max(result3,result4));
        return result;

    }
}
