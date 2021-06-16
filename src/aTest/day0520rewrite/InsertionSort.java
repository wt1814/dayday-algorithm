package aTest.day0520rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: bInsertionSort
 * @Description: TODO  xxxx 没写出来
 * @Author: wt 
 * @CreateDate: 5/20/21 5:00 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void insertionSort(int[] array){

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
