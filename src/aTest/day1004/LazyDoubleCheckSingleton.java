package aTest.day1004;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: LazyDoubleCheckSingleton
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 10/4/21 8:04 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class LazyDoubleCheckSingleton {


    private volatile static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){

    }

    public static LazyDoubleCheckSingleton getInstance(){
        // 第一重检测
        if(lazy == null){
            // 锁定代码块
            synchronized (LazyDoubleCheckSingleton.class){
                // 第二重检测
                if(lazy == null){
                    // 实例化对象
                    lazy = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象
                    //2.初始化对象
                    //3.设置 lazy 指向刚分配的内存地址
                }
            }
        }
        return lazy;
    }


    public void methodOne(){
        System.out.println("逻辑操作");
    }

}
