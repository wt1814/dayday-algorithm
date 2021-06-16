package gSort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class eShellSort {


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


    /**
     *
     * @param array
     */
    public static void sheelSort3(int[] array){
        //增量每次都/2
        for (int step = array.length/2; step>0; step /=2){
            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i<array.length;i++){
                int j = i;
                int temp = array[i];

                //j-step 就是代表与它同组隔壁的元素
                while (j -step >=0 && array[j-step]>temp){

                    array[j] = array[j-step];
                    j = j-step;
                }
                array[j] = temp;
            }
        }
    }


    public static void shellSort3(int[] a) {

        int n = a.length;

        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0 ;i < gap; i++) {

                for (int j = i + gap; j < n; j += gap) {

                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if (a[j] < a[j - gap]) {

                        int tmp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > tmp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = tmp;
                    }
                }
            }
        }
    }

}
