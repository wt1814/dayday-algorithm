package bBasic;

/**
 * 时间复杂度
 */
public class aTimeComplexity {


    // https://zhuanlan.zhihu.com/p/50479555

    /**
     * 常数阶   O(1)
     */
    public void constantOrder(){
        int i = 1;
        System.out.println(i);

    }

    /**
     * 线性阶   O(n)
     */
    public void LinearOrder(int n){

        for (int i = 0; i < n; i++){
            System.out.println(i);
        }

    }

    /**
     * 平方阶   O(n^2)
     */
    public void SquareOrder(int n){

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.println(i*j);
            }
        }
    }

    /**
     * 对数阶   O(logN)
     */
    public void LogarithmicOrder(int n){

        int i = 1;
        while (i < n){
            i = i * 2;
        }
        System.out.println(i);

    }

    /**
     * 线性对数阶   O(nlogN)
     */
    public void nlognOrder(int n){

        for (int i = 0; i <= n; i++){
            int x = 1;
            while (x < n){
                x = x * 2;
            }
        }

    }

    /**
     * 指数阶   O(2^n)
     */
    public void ExponentialOrder(int n){

    }

    /**
     * 选择语句
     * @param n
     */
    public void choice(int n){

        if (n >100){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.println(i*j);
                }
            }
        }else {
            for (int i = 0; i < n; i++){
                System.out.println(i);
            }
        }

    }


    // ------------------------------比较复杂------------------------------

    // 分析：T(O) = n(当i=1时，里层循环执行次数) + (n -1)(当i=2时，里层循环执行次数) + ... ... + 2(当i=n-2时，里层循环执行次数) + 1(当i=n-1时，里层循环执行次数)
    //           = O(n^2)
    public void c(int n){
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                System.out.println(i+"，"+j);
            }
        }
    }


}
