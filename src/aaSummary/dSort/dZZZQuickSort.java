package aaSummary.dSort;

import java.util.Arrays;

// todo 快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后序遍历

/**
 * 快速排序
 * todo *** 递归实现
 * todo 双边循环也有两种
 * todo 一种是找到右边比baseData大的，找到左边比baseData小的，再交换，最后交换两指针重合位置的值和baseData
 * todo 一种是找到右边比baseData大的，就交换baseData和右边值（推荐这种）
 */
public class dZZZQuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,4,6,5,3,2,8,1};
        quickSort2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
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
    public static void quickSort2(int[] array, int left, int right) {

        if(left > right) {
            return;
        }

        //todo 获取基准元素的下标，获取的是下标，而不是值
        //todo 注意是移动后的基准元素的下标，而不是基准元素的初始下标
        int i = partition3(array, left, right);  // todo 返回的是基准元素的下标 // todo 返回的是数组下标 // todo 返回的是数组下标

        count++;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // todo i的索引处为上面已确定好的基准值的位置，无需再处理， 所以左边界i-1，右边界i+1
        quickSort2(array, left, i - 1);
        quickSort2(array, i + 1, right);

    }

    ///////////////

    //分割
    // todo 返回的是基准元素的下标
    //todo 注意方法 #partition3() 与方法 #getBase() 的区别
    public static int partition3(int[] a, int left, int right){

        //基准值
        int base = a[left];

        while(left < right){
            while (left < right && a[right] >= base){
                right--;
            }
            swap(a,left,right);

            while(left < right && a[left] <= base){
                left++;
            }
            swap(a,left,right);
        }
        return left;

    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    //////////////////////////////

    /**
     * 获取基准位置 2
     * todo 两个交换
     * todo 1. 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
     * todo 2. 将基准数和左右指针重合点位置的数进行交换
     * todo 返回的其实是相撞指针重合位置
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
            while(i < j && array[j] >= base ) {  // todo i<j是为了防止新的一轮循环中 数组array[j]下标越界
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
        return i;   // todo 返回的其实是相撞指针重合位置
    }


}
