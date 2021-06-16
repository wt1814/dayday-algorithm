package aTest.day0510;

import java.util.Stack;

/**
 * 利用栈实现字符串逆序
 */
public class StringReversal {

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
            System.out.println(c);
            stack.push(c);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());   // print 输出字符后，下一个输出字符不会会换展示
            //System.out.println(stack.pop());  // println 输出字符后，下一个输出的字符会换行展示
        }

    }

}
