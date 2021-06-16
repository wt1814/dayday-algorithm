package aTest.day0511;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: BinarySearch
 * @Description: todo 二分查找，关键点：相撞指针到同一个中点，然后返回中点。
 * @Author: wt 
 * @CreateDate: 5/11/21 2:59 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class BinarySearch2 {

/*    int start = 0, end = nums.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;

        if (...) {
            start = mid;
        } else {
            end = mid;
        }
    }*/


    public static void main(String[] args) {
        int[] array = new int[1000];
        for(int i=0; i<1000;i++){
            array[i] = i;
        }
        System.out.println(recursionBinarySearch(array, 0,array.length,175));
    }


    /**
     * 二分查找
     * @param array
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int recursionBinarySearch(int[] array,int start,int end,int target){

        // 递归结束条件
        if (start +1 > end){
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
