package aTest.day0724;

import java.util.ArrayList;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/24/21 11:25 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {

    public static void main(String[] args){
        int[] s = {1,2,3};
        System.out.println(subsets(s));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(S.length == 0){
            return result;
        }

        ArrayList<Integer> resultTemp = new ArrayList();
        zuhe(S,0,result,resultTemp);
        return result;

    }

    public static void zuhe(int[] num,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> resultTemp){
        int l = num.length;
        result.add(resultTemp);

        for(int i = index;i<num.length;i++){
            resultTemp.add(num[index]);
            zuhe(num,index+1,result,resultTemp);
            resultTemp.remove(resultTemp.size()-1);
        }


    }
}
