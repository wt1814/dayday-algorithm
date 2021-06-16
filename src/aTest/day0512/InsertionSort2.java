package aTest.day0512;

import java.util.Arrays;

public class InsertionSort2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] array) {

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
}
