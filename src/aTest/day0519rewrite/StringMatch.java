package aTest.day0519rewrite;

import java.util.Stack;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: StringMatch
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/19/21 2:41 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class StringMatch {


    public static void main(String[] args){
        String str = "12a[b{c}]";
        stringMatch(str);
    }

    public static  void stringMatch(String zifu){
        Stack stack = new Stack();
        char[] chars = zifu.toCharArray();
        for (char c: chars){
            switch (c){
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                    if (!stack.isEmpty()){
                        char ch = (char)stack.pop().toString().toCharArray()[0];
                        if(c=='}' && ch != '{'
                                || c==']' && ch != '['
                                || c==')' && ch != '('){
                            System.out.println("Error:"+ch+"-"+c);
                        }else {
                            System.out.println("Success:"+ch+"-"+c);
                        }
                    }
                    break;
                default:break;
            }


        }


    }
}
