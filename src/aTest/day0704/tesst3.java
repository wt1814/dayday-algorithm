package aTest.day0704;

import java.util.ArrayList;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: tesst3
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/4/21 10:08 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class tesst3 {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        ArrayList<Integer> temp = new ArrayList();

        temp.add(1);
        result.add(temp);
        ArrayList<Integer> temp1 = new ArrayList();
        temp1.add(2);
        temp1.add(3);
        result.add(temp1);


        for(int i = 0;i<result.size();i++){
            if(i%2 == 1){
                ArrayList<Integer> temp2 = result.get(i);
                for(int j = 0;j<temp2.size()/2;j++){
                    int temp4 = temp2.get(j);
                    temp2.set(j,temp2.get(temp2.size()-j-1));
                    temp2.set(temp2.size()-j-1,temp4);


                }
                result.set(i,temp2);
            }
        }

        System.out.println("000000");

    }
}
