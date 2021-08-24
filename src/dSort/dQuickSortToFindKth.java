package dSort;

/**
 * 利用快速排序寻找第K大数
 */
public class dQuickSortToFindKth {


    public static void main(String[] args) {
        int[] arr = new int[] {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(findKth(arr,49,24));
    }

    public static int findKth(int[] a, int n, int K) {

        return quickSort(a,0,n-1,K);
    }

    /**
     * 利用快速排序寻找第K大数
     * todo 每次进行一次快速排序后，就判断基数右侧大于基数的数字个数，与K比较，是否进行二次快速排序，
     * 如果当前基数刚好是第K大数，返回这个数即可；
     * 如果右侧大于基数的数字个数比K小，说明还有数在左边，对左边继续进行快速排序；
     * 如果K大于当前基数的右侧的数字的个数，说明第K大的数在基数的右边，对右边进行快速排序。
     * @param a
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int quickSort(int[] a, int left, int right, int k){

        if(left > right) {
            return -1;
        }
        int point = partition(a,left,right);
        if (point == k-1){
            return a[k-1];
        } else if (point > k-1){
            quickSort(a,left,point-1,k);
        } else{
            quickSort(a,point+1,right,k);
        }
        return a[k-1];
    }

    //分割
    public static int partition(int[] a, int left, int right){
        //基准值
        int base = a[left];

        while(left < right){
            while (left < right && a[right] <= base)
                right--;
            swap(a,left,right);

            while(left < right && a[left] >= base)
                left++;
            swap(a,left,right);
        }
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

}
