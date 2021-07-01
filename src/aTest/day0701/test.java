package aTest.day0701;

import java.util.*;

public class test {


    public static void main(String[] args) {
        int[] arr = new int[] {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(findKth(arr,49,24));
    }

    public static int findKth(int[] a, int n, int K) {
        return quickSort(a,0,n-1,K);
    }

    //快速排序
    public static int quickSort(int[] a, int left, int right, int k){
        if(left < right){
            int point = partition(a,left,right);
            if (point == k-1)
                return a[k-1];
            else if (point > k-1)
                quickSort(a,left,point-1,k);
            else
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