package kRecursion.backtrack.number;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: gPrintAllSubsquenceOfOther
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/12/21 5:34 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class gPrintAllSubsquence {

    public static void main(String[] args){
        int[] num = {1,2,3};
        ArrayList<ArrayList<Integer>> subsets = subsets(num);
        System.out.println("------");
    }


    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        back(S, 0, res,track);
        return res;
    }


    public static void back(int[] S, int start, ArrayList<ArrayList<Integer>> res,LinkedList<Integer> track){

        res.add(new ArrayList<>(track));
        for(int i = start; i < S.length; i++){
            track.add(S[i]);
            back(S, i+1, res,track);
            //撤销 回溯
            track.removeLast();
        }

    }

}
