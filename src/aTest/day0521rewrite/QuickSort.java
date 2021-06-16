package aTest.day0521rewrite;

import java.util.Arrays;

public class QuickSort {



    public static void main(String[] args){
        int[] num = {45,3,78,64,52,11,64,55,99,11,18};
        System.out.println(Arrays.toString(num));
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
        System.out.println("数组个数："+num.length);

    }

    public static void quickSort(int[] arr,int left,int right){

        if (left > right){
            return;
        }

        int baseData = getBaseData(arr,left,right);

        quickSort(arr,left,baseData-1);
        quickSort(arr,baseData+1,right);

    }


    private static int getBaseData(int[] arr, int left, int right) {

        int i = left;
        int j = right;
        int base = arr[left];

        //todo 左右相撞指针，结束条件
        while (i != j){
            while (j > i && arr[j] >= base){
                j--;
            }
            while (j > i && arr[i] <= base){
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        arr[left] = arr[i];
        arr[i] = base;

        return i;
    }


}
