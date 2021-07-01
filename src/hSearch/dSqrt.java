package hSearch;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: dSqrt
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/1/21 1:48 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class dSqrt {


    public static void main(String[] args) {
        System.out.println(sqrt(4));

    }

    public static int sqrt (int x) {
        // write code here

        //查找范围起点
        int start=0;
        //查找范围终点
        int end=x;
        //查找范围中位数
        int mid;

        while(start<=end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(mid * mid == x || ((mid * mid < x) && ((mid+1)*(mid+1)>x))) {
                return mid;
            }else if(mid * mid < x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
