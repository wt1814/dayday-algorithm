package aTest.day0513;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: ShellSort2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/21/21 6:22 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class ShellSort2 {



    public static void main(String[] args) {
        int[] arr = new int[] {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2,69,99};
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------");
        shellSort(arr);
        System.out.println("--------------------排序完成后");
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] a) {

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
