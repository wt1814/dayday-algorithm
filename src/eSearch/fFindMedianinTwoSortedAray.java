package eSearch;

/**
 * 在两个长度相等的排序数组中找到上中位数
 * todo 双指针法
 */
public class fFindMedianinTwoSortedAray {



    /**
     * 首先求出上中位数的下标，然后在合并的过程中求出下标对应的数。
     * @param arr1
     * @param arr2
     * @return
     */
    public static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {

        int len = arr1.length + arr2.length;
        int mid=0;
        //todo
        // 上中位数的下标
        if(len%2==0){
            mid=len/2;
        } else {
            mid=len/2+1;
        }

        int ans=0;
        //todo 两个原数组，再加一个目标数组，共3个数组的指针
        int cnt=0; //表示合并数组的指针
        int a=0,b=0; //a,b分别表示数组arr1,arr2的下标指针

        while(cnt!=mid){  // todo todo todo 迭代次数 等于 上中位数 下标
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
