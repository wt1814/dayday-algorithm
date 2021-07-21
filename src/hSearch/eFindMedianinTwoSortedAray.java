package hSearch;

/**
 * 在两个长度相等的排序数组中找到上中位数
 */
public class eFindMedianinTwoSortedAray {

    ////////////////// todo 双指针法 ////////////////////////////////////

    // 首先求出上中位数的下标，然后在合并的过程中求出下标对应的数，下面是代码:
    int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int len = arr1.length+arr2.length;
        int mid=0;
        //上中位数的下标
        if(len%2==0){
            mid=len/2;
        } else {
            mid=len/2+1;
        }
        int cnt=0;//表示合并数组的指针
        int ans=0;
        int a=0,b=0;//a,b分别表示数组arr1,arr2的下标指针
        while(cnt!=mid){
            if(arr1[a]<=arr2[b]){
                ans=arr1[a];
                a++;//指针后移
            } else{
                ans=arr2[b];
                b++;//指针后移
            }
            cnt++;
        }
        return ans;
    }

}
