package aTest.day0708;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/8/21 5:36 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {


    public static void main(String[] args){

        int[] nums = {3,4,1,5,6,2,7};
        int[][] ints = foundMonotoneStack(nums);
        System.out.println(ints);

    }


    public static int[][] foundMonotoneStack (int[] nums) {
        // write code here

        if(nums.length == 0){
            return null;
        }

        int[][] result = new int[nums.length][2];
        result[0][0] = -1;
        result[nums.length-1][1] = -1;

        for(int i = 0;i<nums.length;i++){

            for(int j = i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    result[i][0] = j;
                    break;
                }
            }

            for(int k = i+1;k<nums.length;k++){
                if(nums[k] < nums[i]){
                    result[i][1] = k;
                    break;
                }
            }
        }
        return result;
    }

}
