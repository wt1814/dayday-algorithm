package fHash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中出现次数超过一半的数字
 */
public class cMoreThanHalfNum {

    public static void main(String[] args){
        int[] arr = {2,2,3,4,8,99,3};
        System.out.println(moreThanHalfNum(arr));
        int[] arr2 = {2,2,3,3,3};
        System.out.println(moreThanHalfNum(arr2));

    }

    public static int moreThanHalfNum(int[] arr){
        int result = -1;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0;i< arr.length;i++){
            Integer integer = hashMap.get(arr[i]);
            if (null != integer){
                hashMap.put(arr[i],integer+1);
            }else {
                hashMap.put(arr[i],1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();  //todo map的遍历
        for (Map.Entry entry:entries){
            Integer value = (Integer) entry.getValue();
            if (value >= arr.length/2){
                result = (Integer) entry.getKey();
            }
        }
        return result;
    }

}
