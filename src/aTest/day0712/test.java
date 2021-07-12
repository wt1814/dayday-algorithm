package aTest.day0712;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/12/21 2:48 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {


    public static void main(String[] args){
        int[] num = {1,1,2};
        ArrayList<ArrayList<Integer>> arrayLists = permuteUnique(num);
        System.out.println("aaaa");
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        ArrayList<ArrayList<Integer>> result = new ArrayList();

        if(num.length == 0){
            return result;
        }
        ArrayList<Integer> resultTemp = new ArrayList();
        Arrays.sort(num);
        printAllSort(num,0,result,resultTemp);
        return result;
    }


    public static void printAllSort(int[] num,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> resultTemp){

        if(index == num.length-1){
            resultTemp = new ArrayList<>();
            for(int j = 0;j<num.length;j++){
                resultTemp.add(num[j]);
            }
            result.add(resultTemp);
            return;
        }

        for(int i = index;i<num.length;i++){
            swap(num,index,i);
            int numtemp = num[i];
            printAllSort(num,index+1,result,resultTemp);
            swap(num,index,i);
        }

    }

    public static void swap(int[] num,int left,int right){
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

}
