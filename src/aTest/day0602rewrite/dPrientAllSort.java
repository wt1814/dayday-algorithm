package aTest.day0602rewrite;

import java.util.ArrayList;
import java.util.List;

public class dPrientAllSort {

    public static void main(String[] args) {
        List<String> stringList = printAllSort("abc");
        for (String str:stringList){
            System.out.println(str);
        }
    }

    public static List<String> printAllSort(String str){
        if (str == null || str.length() == 0){
            return null;
        }
        List<String> stringList = new ArrayList<>();
        char[] chars = str.toCharArray();
        stringList = printAllSort(0,chars,stringList);
        return stringList;
    }

    private static List<String> printAllSort(int i, char[] chars, List<String> stringList) {

        if (i == chars.length){
            stringList.add(new String(chars));
        }

        for (int j = i;j<chars.length;j++) {
            swap(i,j,chars);
            printAllSort(i+1,chars,stringList);
            swap(i,j,chars);
        }
        return stringList;
    }


    public static void swap(int i, int j, char[] chars){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
