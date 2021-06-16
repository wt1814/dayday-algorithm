package aTest.day0519rewrite;

import java.util.Stack;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: StringRevere
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/19/21 2:02 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class StringRevere {

    public static void main(String[] args){


        Stack stack = new Stack<>();
        String a = "how are you";
        char[] cha = a.toCharArray();

        for(char c : cha){
            stack.push(c);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
            // print 输出字符后，下一个输出字符不会会换展示
            // 输出 uoy era woh

            //System.out.println(stack.pop());
            // println 输出字符后，下一个输出的字符会换行展示
            // 输出u
            //o
            //y
            //
            //e
            //r
            //a
            //
            //w
            //o
            //h

        }
    }

}
