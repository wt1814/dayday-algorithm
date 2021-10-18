package dSort;

import java.util.Arrays;

/**
 * 最大堆排序
 */
public class hHeapSort {

    public static void main(String[] args) {

        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    // todo https://www.cnblogs.com/chengxiao/p/6129630.html
    // https://www.cnblogs.com/jingmoxukong/p/4303826.html#%E7%AE%97%E6%B3%95%E5%88%86%E6%9E%90
    /**
     * 堆排序(升序)
     * todo 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * todo 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     * 1. 从最后一个非叶子结点开始（叶结点自然不用调整，第一个非叶子结点 arr.length/2-1=5/2-1=1），从左至右，从下至上进行调整。
     * @param array 待调整的堆
     */
    public static void heapSort(int[] array) {

        // todo 1. 把无序数组构建成最大堆。
        for (int i = (array.length-2)/2; i >= 0; i--) {  //第一个非叶子结点 arr.length/2-1
            //从第一个非叶子结点从下至上，从右至左调整结构
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));

        // 2. 循环交换集合尾部元素到堆顶，并调节堆产生新的堆顶。
        //  进行n-1次循环，完成排序
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            downAdjust(array, 0, i);
        }

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * todo 写法简单
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i]; //先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){ //从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){ //处理左节点还是右节点？如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){ //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;  // todo 直接结束for循环
            }
        }
        arr[i] = temp; //将temp值放到最终的位置

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * todo 容易理解
     * todo https://www.cnblogs.com/jingmoxukong/p/4303826.html#%E7%AE%97%E6%B3%95%E5%88%86%E6%9E%90
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];

        int childIndex = 2 * parentIndex + 1; // 先获得左孩子
        while (childIndex < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则定位到右孩子结点
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于等于任何一个孩子的值，直接结束
            if (temp >= array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            // 把孩子结点的值赋给父结点
            array[parentIndex] = array[childIndex];

            //todo 选取孩子结点的左孩子结点，继续向下筛选
            //todo 对比for循环的区别，while循环此处要编码修改指针
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }

        array[parentIndex] = temp;
    }


}
