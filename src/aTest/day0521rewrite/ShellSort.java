package aTest.day0521rewrite;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: eShellSort
 * @Description: TODO  希尔排序
 * @Author: wt 
 * @CreateDate: 5/21/21 3:33 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class ShellSort {


    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){

        int n = arr.length;

        for (int i = n/2;i>0;i=i/2){

            for (int j = i; j<n; j++){


            }
        }

    }
}
