package aTest.day0712;

import java.util.ArrayList;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test3
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/12/21 5:12 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test3 {

    public static void main(String[] args){
        int[] num = {1,2,3};
        ArrayList<ArrayList<Integer>> subsets = subsets(num);
        System.out.println("-----");
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(S.length == 0){
            return result;
        }

        ArrayList<Integer> resultTemp = new ArrayList();
        zuhe(S,0,result,resultTemp,false);
        return result;

    }

    public static void zuhe(int[] num, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> resultTemp,boolean b){

        if(index == num.length){

            ArrayList<Integer> r = new ArrayList<>();
            for (Integer integer:resultTemp){
                r.add(integer);
            }
            result.add(r);

            return;
        }


        zuhe(num,index+1,result,resultTemp,resultTemp.add(num[index]));

        zuhe(num,index+1,result,resultTemp,resultTemp.add(num[index]));
    }
}
