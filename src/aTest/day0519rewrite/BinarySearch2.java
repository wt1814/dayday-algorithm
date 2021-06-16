package aTest.day0519rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: BinarySearch2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/19/21 5:35 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class BinarySearch2 {


    public static void main(String[] args){
        int arr[] = {1,
                2, 2, 5, 5, 5,
                5, 5, 5, 5, 5,
                5, 5, 6, 6, 7};

        System.out.println("找出第一个与key相等的元素："+searchFirstEqual(arr,1));

    }


    /**
     * 找出第一个与key相等的元素
     * @param arr
     * @param target
     * @return
     */
    public static int searchFirstEqual(int[] arr, int target){

        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            if (arr[left] < target){
                ++left;
            }else if (arr[left] >= target){
                --right;
            }
        }

        while (arr[left] == target){
            return left;
        }
        return -1;

    }

}
