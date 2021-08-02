package aTest.day0802;

import java.util.Arrays;

public class test {

    public static void main(String[] args){
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {3,4,5,6};
        int[] arr3 = {0,1,2};
        int[] arr4 = {3,4,5};
        int medianinTwoSortedAray = findMedianinTwoSortedAray(arr1, arr2);
        int medianinTwoSortedAray2 = findMedianinTwoSortedAray(arr3, arr4);
        System.out.println(medianinTwoSortedAray);
        System.out.println(medianinTwoSortedAray2);
    }

    public static int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int result = -1;
        int len = arr1.length;
        if(len == 0){
            return result;
        }

        int count = 1;
        int left = 0;
        int right = len-1;
        while(count <= len && left <= len-1 && right>=0){
            if (len %2 == 0){
                if(arr1[left] >= arr2[right]){
                    result = arr1[left];
                    left++;
                }else{
                    result = arr2[right];
                    right--;
                }
            }else {
                if(arr1[left] <= arr2[right]){
                    result = arr1[left];
                    left++;
                }else{
                    result = arr2[right];
                    right--;
                }
            }
            count++;
        }

        return result;

    }
}
