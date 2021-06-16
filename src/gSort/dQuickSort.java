package gSort;

import java.util.Arrays;

/**
 * 快速排序(递归实现) 
 */
public class dQuickSort {


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

        // 获取基准元素
        int i = getBase(array, left, right);

        count++;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // todo i的索引处为上面已确定好的基准值的位置，无需再处理， 所以左边界i-1，右边界i+1
        quickSort2(array, left, i - 1);
        quickSort2(array, i + 1, right);

    }

    /**
     * 获取基准位置
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
        return i;   // todo 返回的其实是相撞指针重合位置
    }


    ////////////////////////////////////////////////////////////////////////////////

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partitionV2(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }


    /**
     * 分治（双边循环法）
     * @param arr     待交换的数组
     * @param startIndex    起始下标
     * @param endIndex    结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while( left != right) {
            //控制right指针比较并左移
            while(left<right && arr[right] > pivot){
                right--;
            }
            //控制left指针比较并右移
            while( left<right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if(left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * 分治（单边循环法）
     * @param arr     待交换的数组
     * @param startIndex    起始下标
     * @param endIndex    结束下标
     */
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int mark = startIndex;

        for(int i=startIndex+1; i<=endIndex; i++){
            if(arr[i]<pivot){
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
