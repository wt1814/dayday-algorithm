package eSearch;

/**
 * todo 递归解二分查找
 * todo 关键点：相撞指针到同一个中点，然后返回中点。
 * todo todo todo
 *
 * 二分查找，将一个集合分成三部分
 */
public class bBinarySearchOfRecursion {

    public static void main(String[] args) {

        int[] array = new int[1000];
        for(int i=0; i<1000;i++){
            array[i] = i;
        }
        System.out.println(recursionBinarySearch(array, 0,array.length,173));
    }

    /**
     * 递归实现
     * @param array
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int recursionBinarySearch(int[] array,int start,int end,int target){

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
