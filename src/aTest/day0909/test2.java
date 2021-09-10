package aTest.day0909;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 9/11/21 12:00 AM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test2 {


    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        searchRange(nums,8);
    }

    public static int[] searchRange(int[] nums, int target) {

        int index = recursionBinarySearch(nums, 0, nums.length - 1, target);

        int[] result = new int[2];
        if(-1 == index){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        while(index >0){
            if(result[index] == target){
                result[0] = index;
                index--;
            }else{
                break;
            }
        }

        while(index < result.length){
            if(result[index] == target){
                result[1] = index;
                index++;
            }else{
                break;
            }
        }

        return result;
    }


    public  static int recursionBinarySearch(int[] array,int start,int end,int target){

        if (start > end){
            return -1;
        }

        int mid=start+(end-start)/2;
        if (target == array[mid]) {
            return mid;
        } else if (target < array[mid]) { //比关键字大则关键字在左区域
            return recursionBinarySearch(array, start, mid - 1, target);
        } else { //比关键字小则关键字在右区域
            return recursionBinarySearch(array, mid + 1, end, target);
        }
    }

}