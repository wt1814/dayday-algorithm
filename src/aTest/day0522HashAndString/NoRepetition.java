package aTest.day0522HashAndString;

import java.util.HashMap;

/**
 * todo 最长无重复子数组、最长无公共子串，可以采用双子针+Hash
 * 最长重复子数组、最长公共子序列，采用动态规划
 */
public class NoRepetition {

    // 视频：https://www.bilibili.com/video/BV1uA411H7nU?from=search&seid=15230108891070554197

    public static void main(String[] args){
        int[] arr = {2,2,3,4,8,99,3};
        System.out.println(maxLength(arr));
    }

    public static int maxLength (int[] arr) {
        // 只新增、修改，不删除
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // key存储数组中的值，value存储下标
        int start = 0;
        int end = 0;
        int max = 1;

        while (end < arr.length){
            Integer isHave = hashMap.get(arr[end]);
            if (isHave == null || isHave < start){
                max = Math.max(max,end - start +1);
            }else { // 已经有了
                start = isHave + 1;
            }
            hashMap.put(arr[end],end);
            end++;

        }

        return max;
    }

    public static int maxLength2 (int[] arr) {
        // write code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 1;
        for (int i = 0, j = 0; j < arr.length; j++) {
            // 如果该元素重复,调整起始位置
            if (hashMap.containsKey(arr[j])) {
                i = Math.max(hashMap.get(arr[j]) + 1, i);
                // 因为当前元素已经重复了，所以新的i要在当前元素上加1，也就是向后挪一位
                // 为了避免遇到的索引比当前i还小，所以要比较大小
                // 为什么？因为太小的索引不需要再去计算，之前的结果已经存过max中了
            }
            // 如果改元素没有重复
            hashMap.put(arr[j], j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

}
