package eSearch;

/**
 * “旋转数组”中的二分查找
 * todo 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代 迭代
 * todo 二分查找算法不限于运用在有序数组上。如果能够明确二分之后，答案存在于二分的某一侧，就可以使用二分
 */
public class dRotatedBinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{9,10,11,12,13,1,3,4,5,8};
        System.out.println(rotatedBinarySearch(array, 12));

    }

    /**
     * “旋转数组”中的二分查找
     * @param array
     * @param target
     * @return
     */
    public static int rotatedBinarySearch(int[] array, int target){

        int start = 0, end = array.length-1;

        while(start<=end) {  //todo 递归转迭代
            int mid = start + (end-start)/2;
            if(array[mid]==target){
                return mid;
            }

            else if(array[mid]>=array[start]) {  //todo 情况A：旋转点在中位数右侧
                //最左侧元素 <= 查找目标 < 中位数
                if(array[start]<=target && array[mid]>target){  // todo 旋转点在中位数右侧，考虑左侧
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else if(array[mid]<=array[start])  {   //todo 情况B：旋转点在中位数左侧，或与中位数重合
                //中位数 < 查找目标 <= 最右侧元素
                if(array[mid]<target && target<=array[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}

