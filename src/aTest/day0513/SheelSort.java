package aTest.day0513;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: eShellSort
 * @Description: TODO  希尔排序
 * @Author: wt 
 * @CreateDate: 5/13/21 2:53 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class SheelSort {


    //希尔 根据步长分组。步长越长，分组越少；每一步相当于插入排序；直至步长为1时，相当于冒泡排序。

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(7/2);

        int[] arr = new int[] {2,5,3,7,1,8,3,9,0};
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------");
        int[] ints = shellSort(arr);
        System.out.println("--------------------排序完成后");
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 希尔排序
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array){

        int n = array.length;

        //遍历所有的步长，即一共进行多少趟，一共i组。
        for (int i = n/2; i>0; i = i/2) {
            //每一趟一共有多少组。int j=i，希尔排序内部使用插入排序，插入排序首元素默认有序，从次元素开始。j++，
            for (int j=i; j<n; j++) {
                // 在子数组内进行插入排序（交换）
                for (int k = j; k >=i ; k = k-i) {
                    //
                    if (array[k] < array[k-i]){
                        int temp = array[k];
                        array[k] = array[k-i];
                        array[k-i] = temp;
                    }

                }
                System.out.println("---每组后 "+Arrays.toString(array));

            }

            System.out.println("++++++一趟后："+Arrays.toString(array));
        }
        return array;
    }


}
