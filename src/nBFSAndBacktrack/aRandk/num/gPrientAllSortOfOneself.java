package nBFSAndBacktrack.aRandk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组全排列
 */
public class gPrientAllSortOfOneself {


    public static void main(String[] args) {

        int[] arr = {1,2,3};
        permute(arr);

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        permute1(result,nums,0);
        return result;
    }


    public static void permute1(List<List<Integer>> result,int[] nums,int index){

        if(index == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }

            result.add(list);
        }

        for(int i = index;i<nums.length;i++){
            swap(nums,index,i);    // todo
            permute1(result,nums,index+1);  // todo
            swap(nums,i,index);   // todo
        }

    }

    public static void swap (int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

