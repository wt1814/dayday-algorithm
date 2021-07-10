package aTest.day0710;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {

        int[] a = {5,4,1,1,5,1,5};

        System.out.println(foundOnceNumber(a,3));

    }
    public static int foundOnceNumber (int[] arr, int k) {
        // write code here
        int result = -1;

        if(arr.length == 0){
            return result;
        }

        Arrays.sort(arr);

        for(int i = 0;i<arr.length;i= i+k){
            if(i!= arr.length-1 && arr[i] != arr[i+1]){
                result = arr[i];
                break;
            }else{
                result = arr[arr.length -1];
            }
        }

        return result;

    }

}
