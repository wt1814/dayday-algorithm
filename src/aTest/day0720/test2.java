package aTest.day0720;

import java.util.Stack;

/**
 * 表达式求值
 */
public class test2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public static int solve (String s) {
        // write code here
        char[] c=s.toCharArray();
        Stack<Integer> intS=new Stack<>();
        Stack<Character> syS=new Stack<>();
        int i=0;
        int res=0;
        while(i<c.length){
            //左括号直接入符号栈
            if(c[i]=='(')
                syS.push(c[i]);
            else if(c[i]==')'){
                //右括号则循环判断符号栈栈顶是否是左括号，若不是则计算数字栈顶的两个值
                while(syS.peek()!='('){
                    res=compute(intS.pop(),intS.pop(),syS.pop());
                    intS.push(res);
                }
                //此时遇到左括号，将左括号出栈即可
                syS.pop();
            }
            //判断是否是数字
            else if(Character.isDigit(c[i])){
                int j=i+1;
                String num=""+c[i];
                //计算多位数字字符构成的数字
                while(j<c.length&&Character.isDigit(c[j])){
                    num=num+c[j];
                    j++;
                }
                //将数字入数字栈
                intS.push(strToInt(num));
                i=j;
                continue;
            }else{
                //剩下的情况遇到运算符，比较当前运算符和栈顶运算符的优先级，若当前优先级大则直接入栈，否则字符栈出栈，并计算数字栈头两个数字的值。
                if(syS.isEmpty()||compare(c[i],syS.peek())){
                    syS.push(c[i]);
                }else{
                    //优先级更低，先计算符号栈栈顶的运算符
                    while(!compare(c[i],syS.peek())){
                        res=compute(intS.pop(),intS.pop(),syS.pop());
                        intS.push(res);
                        //若符号栈为空则表示计算完毕
                        if(syS.isEmpty())
                            break;
                    }
                    //此时符号栈剩下的运算符优先级更低，直接将当前运算符入栈
                    syS.push(c[i]);
                }
            }
            i++;
        }
        //符号栈还不为空说明没有计算完
        while(!syS.isEmpty()){
            res=compute(intS.pop(),intS.pop(),syS.pop());
            intS.push(res);
        }
        return res;
    }

    public static int strToInt(String s){
        int len=s.length();
        int res=0;
        for(int i=0;i<len;i++){
            res+=Integer.valueOf(s.substring(i,i+1))*Math.pow(10,len-1-i);
        }
        return res;
    }

    public static int compute(int a,int b,char c){
        if(c=='*')
            return a*b;
        if(c=='-')//注意这里做减法和除法要用后一个减(除)前一个，因为栈是先进后出和数学计算规则是相反的
            return b-a;
        if(c=='+')
            return a+b;
        if(c=='/')
            return b/a;
        return 0;
    }

    public static boolean compare(char c,char d){
        //这里判断优先级，别忘了左括号的优先级是最低的，
        if(c=='*'||c=='/'){
            if(d=='+'||d=='-'||d=='(')
                return true;
            else
                return false;
        }
        if(c=='-'||c=='+'){
            if(d=='(')
                return true;
            else
                return false;
        }
        return true;
    }

}
