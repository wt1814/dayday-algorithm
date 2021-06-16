package aTest.day0526rewrite;

import java.util.HashMap;

public class NoRepetition {

    public static void main(String[] args){
        int[] arr = {2,2,3,4,8,99,3};
        System.out.println(maxLength(arr));

    }

    public static int maxLength(int[] arr){

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 1;

        for (int start = 0,end = 0;end<arr.length;end++){
            if (hashMap.containsKey(arr[end])){
                start = Math.max(hashMap.get(arr[end])+1,end);
            }
            hashMap.put(arr[end],end);
            max = Math.max(max, end - start + 1);

        }
        return max;

    }
}
