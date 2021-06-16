package gSort;

/**
 * 利用快速排序寻找第K大数
 */
public class nFindKth {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,2,2};
        int kth = findKth(arr, 5, 5);
        System.out.println(kth);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n-1, K);
    }

    /**
     * 利用快速排序寻找第K大数
     * todo 每次进行一次快速排序后，就判断基数右侧大于基数的数字个数，与K比较，是否进行二次快速排序，
     * 如果当前基数刚好是第K大数，返回这个数即可；
     * 如果右侧大于基数的数字个数比K小，说明还有数在左边，对左边继续进行快速排序；
     * 如果K大于当前基数的右侧的数字的个数，说明第K大的数在基数的右边，对右边进行快速排序。
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }

    /**
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
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

}
