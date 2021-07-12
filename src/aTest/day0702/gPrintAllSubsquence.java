package aTest.day0702;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: gPrintAllSubsquenceOfOther
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/2/21 2:12 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class gPrintAllSubsquence {

    public static void main(String[] args){
        String str = "abc";
        ArrayList<String> list = printAllSubsquence(str);
        for (String s:list){
            System.out.println(s);
        }
    }

    private static ArrayList<String> printAllSubsquence(String str) {

        ArrayList<String> result = new ArrayList<>();

        char[] chars = str.toCharArray();
        allSubsquence(result,"",chars,0);

        return result;
    }


    private static void allSubsquence(ArrayList<String> result,String pre,char[] chars,int i){

        if (i == chars.length){ //todo 最后会执行一次i+1，所以是chars.length，而不是chars.length-1
            result.add(pre);
            return;
        }

        //要当前元素
        allSubsquence(result,pre+chars[i],chars,i+1);
        //不要当前元素
        allSubsquence(result,pre,chars,i+1);
    }
}
