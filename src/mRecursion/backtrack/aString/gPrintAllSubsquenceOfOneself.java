package mRecursion.backtrack.aString;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串组合
 */
public class gPrintAllSubsquenceOfOneself {


    public static void main(String[] args){

        List<String> strings = printAllSubString("abc");
        for (String str:strings){
            System.out.println(str);
        }
    }

    /**
     *
     * @param str
     * @return
     */
    public static List<String> printAllSubString(String str){
        List<String> result = new ArrayList<>();
        if (str == null || str.trim().equals("")){
            return result;
        }

        char[] chars = str.toCharArray();
        String resultTemp = "";

        printAllSubString(chars,0,resultTemp,result);

        return result;
    }

    private static void printAllSubString(char[] chars,int index, String resultTemp, List<String> result) {

        result.add(resultTemp);   // todo 所有结果添加到结果集中

        for(int i = index;i<chars.length;i++){  // todo 递归终止条件

            resultTemp = resultTemp+chars[i];
            printAllSubString(chars,i+1,resultTemp,result);
            resultTemp = resultTemp.substring(0,resultTemp.length()-1);

        }

    }

}
