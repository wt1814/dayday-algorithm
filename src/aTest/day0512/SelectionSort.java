package aTest.day0512;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: cSelectionSort
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/12/21 5:10 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class SelectionSort {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        int[] ints = selectionSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {

        // 如果数组长度为0或者1，都是不用排序直接返回
        if (array.length == 0 || array.length == 1 ){
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;    // todo  保存索引信息
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }


}
