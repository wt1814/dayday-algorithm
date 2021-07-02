package kRecursion.backtrack.string;

import java.util.*;
/**
 * 字符串全排列
 */
public class ePrientAllSortSelf {


    public static void main(String[] args) {
        System.out.println("ab".length());
        System.out.println(Permutation("ab"));
    }



    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList();

        if(str.length() == 0){
            return result;
        }else if(str.length() == 1){
            result.add(str);
            return result;
        }

        char[] strs = str.toCharArray();

        permutation1(strs,0,result);

/*
        HashSet<String> set = new HashSet();
        for(int i = 0;i<strs.length-1;i++){
        }

        for(String s:set){
            result.add(s);
        }
*/

        return result;
    }

    public static void permutation1(char[] strs,int i,ArrayList<String> result) {

        if(i == strs.length){
            result.add(new String(strs));
            return;
        }

        for(int j=i;j<strs.length;j++){
            swap(strs,i,j);
            permutation1(strs,i+1,result);
            swap(strs,i,j);
        }

    }

    public static void swap(char[] strs,int j,int i){
        char temp = strs[j];
        strs[j] = strs[i];
        strs[i] = temp;
    }
}
