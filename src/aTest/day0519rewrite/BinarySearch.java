package aTest.day0519rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: BinarySearch
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/19/21 5:11 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class BinarySearch {

    public static void main(String[] arrgs){

        int arr[] = new int[1000];
        for (int i=0 ; i<arr.length;i++){
            arr[i] = i;
        }

        System.out.println(binarySearch(arr,0,arr.length-1,1001));

    }



    public static int binarySearch(int[] arr,int start,int end,int target){
        if (start > end){
            return -1;
        }

        int mid = start + (end - start)/2;
        if (target  == arr[mid]){
            return mid;
        }else if (target < arr[mid]){
            return binarySearch(arr, start, mid - 1, target);
        }else {
            return binarySearch(arr, mid+1, end, target);
        }

    }
}
