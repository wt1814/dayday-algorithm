package hStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 528，使用栈解基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 */
public class dCalculate {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247490373&idx=1&sn=0df0252b8a183aac5bf47b7a24173c24&chksm=fb418865cc360173d488b5a0f252423c4e020d797f75a012b33c843a8964e1754797975eda47&token=1745824839&lang=zh_CN#rd
    /**
     * 由于乘除优先于加减计算，因此不妨考虑先进行所有乘除运算，并将这些乘除运算后的整数值放回原表达式的相应位置，则随后整个表达式的值，就等于一系列整数加减后的值。
     * 基于此，我们可以用一个栈，保存这些（进行乘除运算后的）整数的值。对于加减号后的数字，将其直接压入栈中；对于乘除号后的数字，可以直接与栈顶元素计算，并替换栈顶元素为计算后的结果。
     * 具体来说，遍历字符串 sss，并用变量 preSign\textit{preSign}preSign 记录每个数字之前的运算符，对于第一个数字，其之前的运算符视为加号。每次遍历到数字末尾时，根据 preSign\textit{preSign}preSign 来决定计算方式：
     *     加号：将数字压入栈；
     *     减号：将数字的相反数压入栈；
     *     乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
     * 代码实现中，若读到一个运算符，或者遍历到字符串末尾，即认为是遍历到了数字末尾。处理完该数字后，更新 preSign\textit{preSign}preSign 为当前遍历的字符。
     * 遍历完字符串 sss 后，将栈中元素累加，即为该字符串表达式的值。
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


}
