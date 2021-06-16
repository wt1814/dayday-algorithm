package aTest.day0520rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: cSelectionSort
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/20/21 5:36 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr){
        for (int i = 0 ; i<arr.length;i++){
            int minIndex = i;  // todo  保存索引信息

            for (int j = i ;j<arr.length;j++){
                if (arr[j] < arr[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
