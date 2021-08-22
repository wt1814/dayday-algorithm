package dSort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class aBubbleSort {


    public static void main(String[] args) {
        int arr[] = new int[]{1,6,2,2,5};
        aBubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void BubbleSort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){   //冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){ //todo 最后的xxx不需要再次比较了
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序优化版
     * @param array
     */
    public static void sort(int array[])
    {
        int tmp  = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需
        //
        // 要比到这里为止
        int sortBorder = array.length - 1;
        for(int i = 0; i < array.length; i++)
        {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            for(int j = 0; j < sortBorder; j++)
            {
                if(array[j] > array[j+1])
                {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }


}
