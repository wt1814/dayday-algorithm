package fSlidingWindow.slidingWindow;

import java.util.HashMap;

/**
 * todo 最长无重复子数组、最长无公共子串
 * todo 最长重复子数组、最长公共子序列，采用动态规划
 */
public class bNoRepetition {

    public static void main(String[] args){
        int[] arr = {2,2,3,4,8,99,3};
        System.out.println(maxLength(arr));
        System.out.println(maxLength2(arr));

    }

    // 视频：https://www.bilibili.com/video/BV1uA411H7nU?from=search&seid=15230108891070554197
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength (int[] arr) {
        // write code here
        int result = 0;

        if(arr.length == 0){
            return result;
        }

        HashMap<Integer,Integer> hashTemp = new HashMap(); // key存储数组中的值，value存储下标
        int start = 0;
        int end = 0;
        for(int i = 0;i<arr.length;i++){
            end = i;
            Integer isHave = hashTemp.get(arr[i]);
            if(isHave == null || isHave < start){  // todo 没有或者不相干
                result = Math.max(result,end - start+1);
            }else{ // todo 已经有了
                start = isHave+1;
            }

            // todo 下面这种写法错误
/*            if(isHave != null){
                start = isHave+1;
            }else{
                result = Math.max(result,end - start+1);
            }*/

            hashTemp.put(arr[i],i);
        }
        return result;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int maxLength2 (int[] arr) {
        // write code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 1;
        for (int start = 0, end = 0; end < arr.length; end++) {
            // 如果该元素重复,调整起始位置
            if (hashMap.containsKey(arr[end])) {
                start = Math.max(hashMap.get(arr[end]) + 1, start);
                // 因为当前元素已经重复了，所以新的i要在当前元素上加1，也就是向后挪一位
                // 为了避免遇到的索引比当前i还小，所以要比较大小
                // 为什么？因为太小的索引不需要再去计算，之前的结果已经存过max中了
            }
            // 如果改元素没有重复
            hashMap.put(arr[end], end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

}
