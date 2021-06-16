package aTest.day0519rewrite;

public class RotatedBinarySearch {


    public static void main(String[] args) {
        int[] array = new int[]{9,10,11,12,13,1,3,4,5,8};
        System.out.println(rotatedBinarySearch(array, 12));
    }


    public static int rotatedBinarySearch(int arr[],int target){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target){
                return mid;
            }else if (arr[start] <= arr[mid]){ //旋转点在右侧
                if (arr[mid] <= target && target <= arr[end]){
                    start = mid +1;
                }else {
                    end = mid -1;
                }

            }else {
                if (arr[mid] >= target && target >= arr[start]){
                    end = mid -1;
                }else {
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
