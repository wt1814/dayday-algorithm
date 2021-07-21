package hSearch;

/**
 * todo 二分查找
 * todo 关键点：相撞指针到同一个中点，然后返回中点。
 * todo todo todo
 *
 * 二分查找，将一个集合分成三部分
 */
public class aBinarySearch {

    public static void main(String[] args) {

        int[] array = new int[1000];
        for(int i=0; i<1000;i++){
            array[i] = i;
        }
        System.out.println(recursionBinarySearch(array, 0,array.length,173));
        System.out.println(binarySearch(array, 173));
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

/*        if (start <= end) {
            int mid=start+(end-start)/2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) { //比关键字大则关键字在左区域
                return recursionBinarySearch(array, start, mid - 1, target);
            } else { //比关键字小则关键字在右区域
                return recursionBinarySearch(array, mid + 1, end, target);
            }
        } else {
            return -1;
        }*/
    }

    /**
     * 非递归实现，while循环
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int []array,int target){



        //查找范围起点
        int start=0;
        //查找范围终点
        int end=array.length-1;
        //查找范围中位数
        int mid;

        while(start<=end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }


}
