package aTest.day0626rewrite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ePrientAllSort {

    public static void main(String[] args) {
        System.out.println(Permutation("aa"));
    }

    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<String>();
        if(str == null || str.length() == 0){
            return result;
        }
        char[] chars = str.toCharArray();
        result = printAll(result,chars,0);
        result = new ArrayList<String>(new HashSet<>(result));
        return result;
    }

    public static ArrayList<String> printAll(ArrayList<String> result,char[] chars,int k) {

        if(k == chars.length){
            result.add(new String(chars));
            return result;
        }

        for(int i = k;i<chars.length;i++){
            swap(chars,k,i);
            printAll(result,chars,k+1);
            swap(chars,k,i);
        }

        return result;
    }


    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
