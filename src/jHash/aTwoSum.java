package jHash;

public class aTwoSum {

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public static int[] twoSum (int[] numbers, int target) {
    	
        // write code here
        int[] arr = new int[2];

        for(int i = 0;i<numbers.length;i++){
            int cha = target - numbers[i];
            for(int j = i+1;j<numbers.length;j++){
                if(numbers[j] == cha){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
        
    }

}
