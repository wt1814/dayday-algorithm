package eStack;

import java.util.Stack;

/**
 * 利用栈实现字符串逆序
 */
public class aStringReversal {

    public static void main(String[] args){
        testStringReversal();
    }

    /**
     * 利用栈实现字符串逆序
     */
    public static void testStringReversal(){

        Stack stack = new Stack();
        String str = "how are you";
        char[] cha = str.toCharArray();  //toCharArray() 方法将字符串转换为字符数组。
        for(char c : cha){
            System.out.print(c);
            stack.push(c);
        }
        System.out.print("\n");   // print 输出字符后，下一个输出字符不会会换展示
        while(!stack.isEmpty()){
            System.out.print(stack.pop());   //todo print 输出字符后，下一个输出字符不会会换展示
            //System.out.println(stack.pop());  //todo println 输出字符后，下一个输出的字符会换行展示
        }

    }

}
