package aTest.day0701;

import java.util.Arrays;

public class te5 {

    public static void main(String[] args) {
        int[] arr = new int[] {5,2,3,1,4};
        int[] ints = MySort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] MySort (int[] arr) {
        // write code here
        if(arr.length == 0){
            return null;
        }
        quickSort(arr,0,arr.length-1);
        return arr;
    }


    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }

        int base = baseData1(arr,left,right);
        quickSort(arr,left,base-1);
        quickSort(arr,base+1,right);

    }

    public static int baseData1(int[] arr,int left,int right){
        int base = arr[left];
        int i = left;
        int j = right;
        while(i < j){
            while(i<j && arr[j] >= base){
                j--;
            }
            swap(arr,i,j);
            while(i<j && arr[i] <= base){
                i++;
            }
            swap(arr,i,j);
        }
        return left;
    }

    public static int baseData(int[] arr,int left,int right){
        int base = arr[left];

        while(left < right){
            while(left<right && arr[right] >= base){
                right--;
            }
            swap(arr,left,right);
            while(left<right && arr[left] <= base){
                left++;
            }
            swap(arr,left,right);
        }
        return left;
    }

    public static int partition3(int[] a, int left, int right){
        //基准值
        int base = a[left];

        while(left < right){
            while (left < right && a[right] >= base)
                right--;
            swap(a,left,right);

            while(left < right && a[left] <= base)
                left++;
            swap(a,left,right);
        }
        return left;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
