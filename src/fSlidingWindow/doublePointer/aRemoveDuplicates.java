package fSlidingWindow.doublePointer;

/**
 * 539，双指针解删除有序数组中的重复项
 */
public class aRemoveDuplicates {


    public static void main(String[] args) {

    }

    //双指针解决
    public static int removeDuplicates(int[] A) {

        //边界条件判断
        if (A == null || A.length == 0){
            return 0;
        }
        int left = 0;
        for (int right = 1; right < A.length; right++){
            // todo 如果左指针和右指针指向的值一样，说明有重复的，这个时候，左指针不动，右指针继续往右移。
            // todo 如果它俩指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right]){
                A[++left] = A[right];
            }
        }
        return ++left;
    }

}
