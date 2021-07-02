package aTest.day0701;

import java.util.*;

public class ts4 {

    public static void main(String[] args) {
        String a ="))())(()))()(((()())(()(((()))))((()(())()((((()))())))())))()(()(()))))())(((())(()()))((())()())((()))(()(())(())((())((((()())()))((()(())()))()(()))))))()))(()))))()())()())()()()()()()()))()(((()()((()(())((()())))(()())))))))(()()(())())(()))))))()()())((((()()()())))))((())(())()()(()((()()))()()())(()())()))()(()(()())))))())()(())(()))(())()(())()((())()((((()()))())(((((())))())())(()((())((()()((((((())))(((())))))))(()()((((((()(((())()(()))(()())((()(((()((()(())())()())(((()))()(((()))))(())))(())()())()(((()))))((())())))())()()))((((()))(())()())()(((())(())(()()((())()())()()())())))((()())(()((()()()(()())(()))(()())((((()(()(((()(((())()((()(()))())()())))))))))))()())()(()(((())()))(((()))((((()())())(()())((()())(()()((()((((()())))()(())(())()))))(())())))))(((((((())(((((()))()))(()()()()))))))(()(()(()(()()(((()()))((()))())((())())()())()))()()(((())))()(())()()(())))(((()))))))))(())((()((()((()))))()()()((())((((((((((()(())))(())((()(()())())(((((((()()()()))())(((()())()(()()))))(()()))))(((()()((()()()(((()))))(()()())()()()(()))))()(())))))))()((((((((()((())))))))(()))()((()())())(";
        System.out.println(a.length());
        String b = "(((()" +
                "(((((((((()";
        String c = ")(";

        System.out.println(longestValidParentheses(c));
    }

    public static int longestValidParentheses (String s) {
        // write code here

        if(s == null || s.length() == 0 || s.length() ==1){
            return 0;
        }

        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack(); // 使用栈
        List<Integer> list = new ArrayList<>(); //todo 使用list保存所有可以成对的下标
        for(int i = 0;i<str.length;i++){
            if(String.valueOf(str[i]).equals("(")){
                stack.push(i);
            }else if(String.valueOf(str[i]).equals(")")){
                if(!stack.isEmpty()){
                    Integer num = stack.pop();
                    if((i-num)%2 == 1 ){
                        list.add(num);
                        list.add(i);
                    }
                }
            }
        }
        Collections.sort(list);

        int result = 0;
        int num = 0;

        //todo 求最长递增子数组
        for (int i = 1;i<list.size();i++){
            if (list.get(i)-list.get(i-1) == 1){
                num++;
            }else {
                result = Math.max(result,num);
                num = 0;
            }
        }
        result = Math.max(result,num);
        return (result == 0)?0:result+1;
    }
}
