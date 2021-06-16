import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @ProjectName：java-algorithm
 * @ClassName: Test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 2020-05-19 10:04
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class Test {


    public static void main(String[] args) throws Exception {
        System.out.println(38974*38974);
        System.out.println(38975*38975);
        System.out.println(1423868673*1423868673);
        System.out.println(1423868674*1423868674);
        System.out.println(sqrt(1518991037));



    }

    /**
     *
     * @param x int整型
     * @return int整型
     */
    public static int sqrt (int x) {
        // write code here

        if(x == 0 || x ==1){
            return x;
        }

        //查找范围起点
        int start=0;
        //查找范围终点
        int end=x;
        //查找范围中位数
        int mid;

        while(start<end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(mid == x /mid || ((mid < x /mid) && ((mid+1) >x /(mid+1)))) {  //todo 防止int超范围，用除法
                return mid;
            }else if(mid < x / mid){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;

    }

}
