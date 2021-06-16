package aTest.day0512;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: dQuickSort
 * @Description: TODO 快速排序-双边循环
 * @Author: wt 
 * @CreateDate: 5/12/21 4:15 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class QuickSort {


    public static void main(String[] args){
        int[] num = {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println(Arrays.toString(num));
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
        System.out.println("数组个数："+num.length);
        System.out.println("循环次数："+count);

    }

    /**
     * 次数
     */
    private static int count;

    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {

        if(left > right) {
            return;
        }

        int i = getBase(array, left, right);

        count++;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

    }

    /**
     * 获取基准位置
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int getBase(int[] array, int left, int right) {
        // base中存放基准数，提前存放
        int base = array[left];

        // todo 移动指针
        int i = left;
        int j = right;

        //todo 左右相撞指针，结束条件
        while(i != j) {
            // todo 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(i < j && array[j] >= base ) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(i < j  && array[i] <= base) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // todo 将基准数和左右指针重合点位置的数进行交换
        array[left] = array[i];
        array[i] = base;
        return i;
    }

}
