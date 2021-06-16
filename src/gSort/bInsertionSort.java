package gSort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class bInsertionSort {

    /**
     * 插入排序
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 插入排序
     * @param array
     */
    public static void insertSort2(int[] array) {

        if (array.length == 0 || array.length == 1){
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i;j>0;j--){
                if (array[j]< array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        if (array.length == 0 || array.length == 1){
            return;
        }

        for (int i = 0; i < array.length-1; i++) {
            // 第一个数默认已排序，从第二个数开始
            int value = array[i+1];

            // 前一个数的下标
            int j = i;

            // 查找插入的位置
            while (j>=0 && value < array[j]){
                array[j + 1] = array[j];  // 数据移动
                j--;
            }

/*            // 查找插入的位置
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    array[j + 1] = array[j];  // 数据移动
                } else {
                    break;
                }
            }*/

            // 插入数据
            array[j + 1] = value;
        }
    }




}
