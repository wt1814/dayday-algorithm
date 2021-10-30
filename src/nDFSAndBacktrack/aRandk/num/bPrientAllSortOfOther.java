package nDFSAndBacktrack.aRandk.num;

import java.util.Arrays;

/**
 * 46. 数组全排列
 */
public class bPrientAllSortOfOther {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        permutation(arr,0);

    }

    // https://mp.weixin.qq.com/s/8DIZ9qZArmytsoGsnn7b8Q
    // https://programmercarl.com/0046.%E5%85%A8%E6%8E%92%E5%88%97.html
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247492108&idx=1&sn=218469577378cca2c29818fa98b82bac&chksm=fb42712ccc35f83af932533cdc8b46d4adb8d0b8f06841c588a9158f3aa5dc3c69d53b4c0704&scene=21#wechat_redirect
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247492156&idx=1&sn=74650c2009af6631eb5705a2a33f955e&chksm=fb42711ccc35f80ae79938933fde5befcffd4fb5caf4e5977dabcde2564d8c052ac9a560fd73&scene=21#wechat_redirect
    /**
     *
     * @param arr  代表全排列数字组成的数组
     * @param k 代表第几位
     */
    public static void permutation(int[] arr, int k) {
        // 当 k 指向最后一个元素时,递归终止，打印此时的排列排列
        if (k == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = k; i < arr.length; i++) {
            // 将 k 与之后的元素 i 依次交换,然后可以认为选中了第 k 位
            swap(arr, k, i);
            // todo 第 k 位选择完成后，求剩余元素的全排列
            permutation(arr, k+1);
            // 这一步很关键：将 k 与 i 换回来，保证是初始的顺序
            swap(arr, k, i);


        }

    }


    public static void swap (int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
