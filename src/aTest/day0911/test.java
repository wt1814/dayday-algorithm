package aTest.day0911;

import java.util.Stack;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 9/11/21 6:43 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {

    public static void main(String[] args){

        String str = "()";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {

        boolean result = true;
        Stack tempStack = new Stack();

        char[] chars = s.toCharArray();
        if(chars.length <= 1){
            return false;
        }

        for(char ch: chars){
            switch(ch){
                case '(':
                case '{':
                case '[':
                    tempStack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if(!tempStack.isEmpty()){
                        char temp = (char)tempStack.pop().toString().toCharArray()[0];
                        if((temp == '(' && ch == ')') || (temp == '{' && ch == '}') || (temp == '[' && ch == ']') ){
                            result = true;
                        }else{
                            result = false;
                        }
                    }else {
                        result = false;
                    }
                    break;
                default:
                    break;
            }
            if (result == false){
                break;
            }
        }
        if(!tempStack.isEmpty()){
            result = false;
        }

        return result;

    }
}
