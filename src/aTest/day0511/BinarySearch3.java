package aTest.day0511;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: BinarySearch2
 * @Description: TODO  二分查找的变形
 * @Author: wt 
 * @CreateDate: 5/11/21 4:07 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class BinarySearch3 {


    public static void main(String[] args){
        int arr[] = {1,
                2, 2, 5, 5, 5,
                5, 5, 5, 5, 5,
                5, 5, 6, 6, 7};

        System.out.println("找出第一个与key相等的元素："+searchFirstEqual(arr,3));

    }


    /**
     * 找出第一个与key相等的元素
     * @param arr
     * @param key
     * @return
     */
    public static int searchFirstEqual(int arr[], int key) {

        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] >= key){
                right = mid - 1;
            } else if(arr[mid] < key) {
                left = mid + 1;
            }
        }

        if( left < arr.length && arr[left] == key) {
            return left;
        }
        return -1;
    }


    /**
     * 找出最后一个与key相等的元素
     * @param arr
     * @param key
     * @return
     */
    public static int searchLastEqual(int arr[], int key) {

        int left = 0, right = arr.length-1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(arr[mid] > key) {
                right = mid - 1;
            } else if(arr[mid] <= key) {
                left = mid + 1;
            }
        }

        if( right>=0 && arr[right] == key) {
            return right;
        }
        return -1;
    }


    /**
     * 查找第一个等于或者大于Key的元素
     * @param arr
     * @param key
     * @return
     */
    public static int searchFirstEqualOrLarger(int arr[], int key)
    {
        int left=0, right=arr.length-1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(arr[mid] >= key){
                right = mid-1;
            } else if (arr[mid] < key) {
                left = mid+1;
            }
        }

        return left;
    }

}
