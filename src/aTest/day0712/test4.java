package aTest.day0712;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test4
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/12/21 5:47 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test4 {

    public static void main(String[] args){

        List<String> strings = printAllSubString("abc");
        System.out.println("pppppppppp");

    }

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

        result.add(resultTemp);

        for(int i = index;i<chars.length;i++){

            resultTemp = resultTemp+chars[i];
            printAllSubString(chars,i+1,resultTemp,result);
            resultTemp = resultTemp.substring(0,resultTemp.length()-1);

        }

    }


}
