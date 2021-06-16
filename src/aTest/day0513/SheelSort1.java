package aTest.day0513;

import java.util.Arrays;

public class SheelSort1 {


    //希尔 根据步长分组。步长越长，分组越少；每一步相当于插入排序；直至步长为1时，相当于冒泡排序。

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(7/2);

        int[] arr = new int[] {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2,69,99};
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


        return array;
    }
}
