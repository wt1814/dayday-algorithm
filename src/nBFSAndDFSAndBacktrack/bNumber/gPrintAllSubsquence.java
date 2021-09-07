package nBFSAndDFSAndBacktrack.bNumber;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * xxxxx
 */
public class gPrintAllSubsquence {

    public static void main(String[] args){
        int[] num = {1,2,3};
        ArrayList<ArrayList<Integer>> subsets = subsets(num);
        System.out.println(subsets);
    }


    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();  // todo
        back(S, 0, res,track);
        return res;
    }


    public static void back(int[] S, int start, ArrayList<ArrayList<Integer>> res,LinkedList<Integer> track){

        res.add(new ArrayList<>(track)); // todo
        for(int i = start; i < S.length; i++){
            track.add(S[i]);            //todo 操作 索引i，非start
            back(S, i+1, res,track);
            //撤销 回溯
            track.removeLast();
        }

    }

}
