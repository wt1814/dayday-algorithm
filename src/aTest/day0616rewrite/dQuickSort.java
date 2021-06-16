package aTest.day0616rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: dQuickSort
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/16/21 4:40 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class dQuickSort {





    public void queckSort(int[] arr,int left,int right){

        if (left>right){
            return;
        }

        int i = getBase(arr,left,right);
        queckSort(arr,left,i-1);
        queckSort(arr,i+1,right);

    }

    private int getBase(int[] arr, int left, int right) {
        int base = arr[left];
        int i = left;
        int j = right;

        while (i<=j){
            // 1. 从右往左找

            // 2. 从左往右找

            // 3. 交换

        }

        // 4. 交换基准值和相撞指针重合位置


        return 0;
    }


}
