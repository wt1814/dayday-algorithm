package nDFSAndBacktrack.aRandk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 数组全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class aPrientAllSortOfOneself {


    // https://mp.weixin.qq.com/s/8DIZ9qZArmytsoGsnn7b8Q

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);

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

