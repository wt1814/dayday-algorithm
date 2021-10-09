package fSlidingWindow.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 双指针解三数之和
 */
public class bThreeSum {

    public static void main(String[] args) {

    }


    // https://mp.weixin.qq.com/s/NvPpOIbCc_0SRpJqKMgcrA
    /**
     *
     * @param num
     * @return
     */
    public static List<List<Integer>> threeSum(int[] num) {
        //先对数组进行排序
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //过滤掉重复的
            if (i > 0 && num[i] == num[i - 1]){
                continue;
            }
            //因为是排序的，如果第一个数字大于0，那么后面的也都
            //大于0，他们三个数字的和不可能等于0
            if (num[i] > 0){
                break;
            }
            int left = i + 1;//左指针
            int right = num.length - 1;//右指针
            int target = -num[i];
            while (left < right) {
                //左右指针的和
                int sum = num[left] + num[right];
                if (sum == target) {
                    //找到了一组，把他们加入到集合list中
                    res.add(Arrays.asList(num[i], num[left], num[right]));
                    //过滤掉重复的
                    while (left < right && num[left] == num[left + 1]){
                        left++;
                    }
                    while (left < right && num[right] == num[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

/*
    排序的时间复杂度是O(nlogn)，for循环中的时间复杂度是O(n)，for循环里面的时间复杂度是O(n)，他们是相乘的关系，所以他们的时间复杂度是O(n^2)，整个代码的时间复杂度就是O(nlogn)+O(n^2)，也就是O(n^2)。
*/

}
