package aaSummary.dSort;

import java.util.Arrays;

// todo 快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后序遍历

/**
 * 归并排序
 * todo 二分 + 递归
 * todo 1. 先分再合
 * todo 2. 合的时候，设置移动指针，合并“两个待排序数组”
 * todo 2. 1). 双指针同时移动比较， 2). 若左边还有剩余
 */
public class eZZZMergeSortOfRecursion {

    public static void main(String[] args) {

        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array,int left,int right){

        if (left >= right){  // todo 递归的标准步骤
            return;
        }

        int mid = (left+right)/2;
        mergeSort(array,left,mid);   //todo 先分再合
        mergeSort(array,mid+1,right);

        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[array.length];
        merge(array,left,mid,right,temp); //todo 两数组合并

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

        while (i<=mid && j<=right){  //todo 两个数组合并，同时移动指针
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


        while(i<=mid){             //todo 若左边还有剩余，将左边剩余元素填充进temp中
            //temp[t++] = arr[i++];
            temp[t] = arr[i];
            t++;
            i++;

        }

        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t] = arr[j];
            t++;
            j++;
        }


        t = 0;
        //todo 将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }



    ////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param array
     * @param start
     * @param end
     */
    public static void mergeSort1(int[] array, int start, int end){
        if(start < end){
            //折半成两个小集合，分别进行递归
            int mid=(start+end)/2;
            mergeSort1(array, start, mid);
            mergeSort1(array, mid+1, end);
            //把两个有序小集合，归并成一个大集合
            merge1(array, start, mid, end);
        }
    }

    /**
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private static void merge1(int[] array, int start, int mid, int end){

        //开辟额外大集合，设置指针
        int[] tempArray = new int[end-start+1];
        int p1=start, p2=mid+1, p=0;
        //比较两个小集合的元素，依次放入大集合
        while(p1<=mid && p2<=end){
            if(array[p1]<=array[p2]){
                tempArray[p++]=array[p1++];
            }
            else{
                tempArray[p++]=array[p2++];
            }
        }
        //左侧小集合还有剩余，依次放入大集合尾部
        while(p1<=mid){
            tempArray[p++]=array[p1++];
        }
        //右侧小集合还有剩余，依次放入大集合尾部
        while(p2<=end){
            tempArray[p++]=array[p2++];
        }

        //把大集合的元素复制回原数组
        for (int i=0; i<tempArray.length; i++){
            array[i+start]=tempArray[i];
        }

    }

}
