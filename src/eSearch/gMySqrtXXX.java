package eSearch;

/**
 * 剑指 Offer II 072. 求平方根
 * 输入: x = 4 输出: 2
 * todo 输入: x = 8 输出: 2   解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 */
public class gMySqrtXXX {


    public static void main(String[] args) {
        int i = mySqrt(4);
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
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return -1;
    }

}
