package eSearch;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: bBinarySearchOfIteration
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 8/22/21 4:31 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class bBinarySearchOfIteration {


    public static void main(String[] args) {

        int[] array = new int[1000];
        for(int i=0; i<1000;i++){
            array[i] = i;
        }
        System.out.println(binarySearch(array, 173));
    }

    /**
     * 非递归实现，while循环
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int []array,int target){

        //查找范围起点
        int start=0;
        //查找范围终点
        int end=array.length-1;
        //查找范围中位数
        int mid;

        while(start<=end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }


}
