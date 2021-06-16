package aTest.day0527rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: MergeSort
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/27/21 5:50 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int start,int end){
        if (start >= end){
            return;
        }

        int mid = (end+start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);

        int[] temp = new int[arr.length];
        merge(arr,start,mid,end,temp);

    }

    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {

        int left = start;
        int right = mid+1;
        int t = 0;//临时数组指针

        while (left<=mid && right<=end){
            if (arr[left]>arr[right]){
                temp[t] = arr[right];
                right++;

            }else {
                temp[t] = arr[left];
                left++;
            }
            ++t;
            System.out.println(t);
        }

        while (left<=mid){
            temp[t] = arr[left];
            ++t;
            left++;
            System.out.println(t);
        }

        while (right<=end && t<temp.length){

            temp[t] = arr[right];
            right++;
            System.out.println(t);
        }

        //
        for (int i=0;i<temp.length;i++){
            arr[i] = temp[i];
        }

    }
}
