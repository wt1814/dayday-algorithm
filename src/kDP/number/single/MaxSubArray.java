package kDP.number.single;

/**
 * 最大子数组和
 */
public class MaxSubArray {

    public static void main(String[] args){
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }

    //https://www.cnblogs.com/dddyyy/p/10746769.html
    /**
     *
     * @param array
     * @return
     */
    public static int maxSubArray(int[] array){

        if (array.length == 0){
            return 0;
        }

        // dp数组
        int res = 0;
        // base case
        int max = array[0];

        //
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
