package aTest.day0513;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: MergeSort
 * @Description: TODO  归并排序
 * @Author: wt 
 * @CreateDate: 5/13/21 3:16 PM
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

    /**
     * 归并排序
     * // todo 递归的标准步骤
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array,int left,int right){

        if (left >= right){
            return;
        }

        int mid = (left+right)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);

        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[array.length];
        merge(array,left,mid,right,temp);

        return;
    }


    /**
     * 两数组合并
     * @param arr
     * @param left //todo 固定位置
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        // todo 定义可移动的指针
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针


        while (i<=mid && j<=right){
            if (arr[i]>=arr[j]){
                temp[t] = arr[j];
                j++;
            }else {
                temp[t] = arr[i];
                i++;
            }
            t++;
        }

/*        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }*/


        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }

        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }


        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

}
