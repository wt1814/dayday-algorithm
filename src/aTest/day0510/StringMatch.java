package aTest.day0510;

import java.util.Stack;

/**
 * 利用栈判断分隔符是否匹配
 */
public class StringMatch {


    public static void main(String[] args){
        String str = "12<a[b{c}]>";
        stringMatch(str);
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
