package mRecursion;

/**
 * 阶乘
 */
public class aFactorial {

    public static void main(String[] args){

        System.out.println(factorial(3));
    }

    public static int factorial(int n) {

        // 第二步的临界条件
        if (n <=1) {
            return 1;
        }

        // 第二步的递推公式
        int i = n * factorial(n - 1);
        return i;

    }

}
