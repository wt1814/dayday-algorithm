package aTest.day0712;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/12/21 3:13 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test2 {



    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList();

        if(num.length == 0){
            return result;
        }
        ArrayList<Integer> resultTemp = new ArrayList();
        Arrays.sort(num);
        printAllSort(num,0,result,resultTemp,target);
        return result;

    }

    public static void printAllSort(int[] num,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> resultTemp,int target){

        if(index == num.length-1){
            int sum = 0;
            resultTemp = new ArrayList<>();

            for (int k=0;k<num.length;k++){
                resultTemp.add(num[k]);
                sum = sum + num[k];
                if (sum == target){
                    result.add(resultTemp);
                    break;
                }else if (sum > target){
                    break;
                }

            }
            return;
        }

        for(int i = index;i<num.length;i++){
            swap(num,index,i);
            int numtemp = num[i];
            printAllSort(num,index+1,result,resultTemp,target);
            swap(num,index,i);
        }

    }

    public static void swap(int[] num,int left,int right){
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }


}
