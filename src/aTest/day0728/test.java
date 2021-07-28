package aTest.day0728;

import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/28/21 2:27 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {

    public static void main(String[] args){
        int[]  array = {1,2,3,4,5,6,7};
        int[] ints = reOrderArray(array);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] reOrderArray (int[] array) {
        // write code here
        int length = array.length;
        for(int i = 0;i<length;i++){
            if(array[i] %2 ==1){
                if(i == 0){
                    continue;
                }

                int j = i;
                while(j>=1 && array[j-1]%2 ==0){

                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    j--;
                }
            }
        }

        return array;
    }
}
