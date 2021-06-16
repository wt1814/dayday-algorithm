package aTest.day0520rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: aBubbleSort
 * @Description: TODO 冒泡排序
 * @Author: wt 
 * @CreateDate: 5/20/21 4:11 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class BubbleSort {



    public static void main(String[] args) {
        int arr[] = new int[]{1,6,2,2,5};
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            for (int j =i ;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }
}
