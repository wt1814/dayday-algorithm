package eSearch;

/**
 * 剑指 Offer II 072. 求平方根
 * 输入: x = 4 输出: 2
 */
public class gMySqrtXXX {


    public static void main(String[] args) {
        int i = mySqrt(5);
        System.out.println(i);
    }


    // https://leetcode-cn.com/problems/jJ0w9p/

    public static int mySqrt(int x) {

        if (x == 0){
            return 0;
        }

        int left = 0;
        int right = x;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (mid * mid == x){
                return mid;
            }else if(mid * mid > x){
                right = mid;
            }else {
                left = mid;
            }
        }

        return -1;

    }


}
