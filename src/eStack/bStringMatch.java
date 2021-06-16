package eStack;

import java.util.Stack;

/**
 * 利用栈判断分隔符是否匹配
 */
public class bStringMatch {


    public static void main(String[] args){

        String str = "((";
        stringMatch(str);
    }


    @SuppressWarnings("unchecked")
    public boolean isValid (String s) {
        // write code here
        boolean result = true;
        Stack tempStack = new Stack();

        char[] arr = s.toCharArray();
        if(arr.length ==1){
            return false;
        }
        for(char sub:arr){
            result = false;
            switch(sub){   // todo switch使用
                case '(':  // todo char类型定义
                case '{':
                case '[':
                    tempStack.push(sub);
                    break;
                case ')':
                case '}':
                case ']':
                    if(!tempStack.isEmpty()){
                        char temp = (char)tempStack.pop().toString().toCharArray()[0];
                        if((temp == '(' && sub == ')') || (temp == '{' && sub == '}') || (temp == '[' && sub == ']') ){
                            result = true;
                        }else{
                            result = false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if(!tempStack.isEmpty()){
            result = false;
        }

        return result;

    }

    /**
     * 利用栈判断分隔符是否匹配
     * @param str
     */
    public static void stringMatch(String str){
        Stack stack = new Stack();
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;    //todo 利用break可以在执行必要的一个case子句后，跳出switch选择结构
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];  //todo 获取栈中的字节
                        if(c=='}' && ch != '{'
                                || c==']' && ch != '['
                                || c==')' && ch != '('){
                            System.out.println("Error:"+ch+"-"+c);
                        }else {
                            System.out.println("Success:"+ch+"-"+c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
