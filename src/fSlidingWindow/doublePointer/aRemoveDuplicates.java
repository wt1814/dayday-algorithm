package fSlidingWindow.doublePointer;

import java.util.Arrays;

/**
 * 26. 双指针解删除有序数组中的重复项
 */
public class aRemoveDuplicates {


    public static void main(String[] args) {

        int[] arr = {1,2,2,2,3,4,5,5};
        int result = removeDuplicates(arr);
        Arrays.stream(arr).forEach(value -> System.out.print(value));
        //System.out.println(result);
    }


    /**
     * 快指针表示遍历数组到达的下标位置，
     * 慢指针表示下一个不同元素要填入的下标位置，
     * 初始时两个指针都指向下标 1。
     * @param nums 返回不重复数组的下标
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }



    //双指针解决
    public static int[] removeDuplicates2(int[] A) {

        //边界条件判断
        if (A == null || A.length == 0){
            return null;
        }

        int left = 0;
        for (int right = 1; right < A.length; right++){
            // todo 如果左指针和右指针指向的值一样，说明有重复的，这个时候，左指针不动，右指针继续往右移。
            // todo 如果它俩指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right]){
                A[++left] = A[right];
            }
        }
        left++;
        return A;

    }

}
