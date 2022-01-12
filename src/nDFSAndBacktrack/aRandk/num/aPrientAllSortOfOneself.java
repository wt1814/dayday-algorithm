package nDFSAndBacktrack.aRandk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 数组全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class aPrientAllSortOfOneself {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);

    }

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        permuteHelper(result,nums,0);
        return result;
    }

    /**
     *
     * @param result
     * @param nums
     * @param index
     */
    public static void permuteHelper(List<List<Integer>> result,int[] nums,int index){

        if(index == nums.length-1){   // todo 原数组回溯。要复制快照到新数组，用来添加。 防止污染原数组
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
        }

        for(int i = index;i<nums.length;i++){
            swap(nums,index,i);
            permuteHelper(result,nums,index+1);  // todo
            swap(nums,i,index);   // todo 回溯
        }

    }

    public static void swap (int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}

