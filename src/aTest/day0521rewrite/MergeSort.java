package aTest.day0521rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: MergeSort
 * @Description: TODO  归并排序
 * @Author: wt 
 * @CreateDate: 5/21/21 3:07 PM
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

    public static void mergeSort(int[] arr,int left,int right){
        if (left >= right){
            return;
        }

        int mid = (left+right)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        int[] temp = new int[arr.length];

        merge(arr,left,mid,right,temp);



    }

    /**
     * 合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {


        int i = left;
        int j = mid+1;
        int k = 0;  //临时数组指针

        while (i<=mid && j<=right){
            if (arr[i]>=arr[j]){
                temp[k] = arr[j];
                j++;
            }else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }

        while(i<=mid){//将左边剩余元素填充进temp中
            temp[k++] = arr[i++];
        }

        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = arr[j++];
        }


        k = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[k++];
        }


    }


}
