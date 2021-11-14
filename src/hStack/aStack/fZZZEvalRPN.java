package hStack.aStack;

/**
 * 150. 逆波兰表达式求值
 * 中缀表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class fZZZEvalRPN {

    /**
     * 非递归的方法是定义两个 栈 来分别存储运算符和运算数。每当遇到一个数直接放进数的栈；每当遇到一个操作符时，要查找之前运算符栈中的元素，按照预先定义好的优先级来进行适当的弹出操作（弹出的同时求出对应的子表达式的值）。
     */

    // 后缀表达式：只需要 维护一个数字栈，每次遇到一个运算符，就取出两个栈顶元素，将运算结果重新压入栈中。最后，栈中唯一一个元素就是该后缀表达式的运算结果。时间复杂度O(n)。
    // 对于普通中缀表达式的计算，我们可以将其转化为后缀表达式再进行计算。转换方法也十分简单。只要建立一个用于存放运算符的栈，扫描该中缀表达式：
/*    如果遇到数字，直接将该数字输出到后缀表达式（以下部分用「输出」表示输出到后缀表达式）；
    如果遇到左括号，入栈；
    如果遇到右括号，不断输出栈顶元素，直至遇到左括号（左括号出栈，但不输出）；
    如果遇到其他运算符，不断去除所有运算优先级大于等于当前运算符的运算符，输出。最后，新的符号入栈；
    把栈中剩下的符号依次输出，表达式转换结束。
    时间复杂度 。*/


/*
算法：可以使用栈来完成中缀表达式到后缀表达式的转换
1、栈stack[]用来存储操作符，top指向栈顶，但不存储元素，top=0表示栈为空
2、从左向右遍历中缀表达式
　　a.如果遇到的是操作数num，则直接输出到后缀表达式
　　b.如果遇到的是操作符op，则有几种情况：
       b.1.如果op==')'，则依次弹出栈顶直到弹出'('，但'('不输出到后缀表达式
　　　　b.2:如果op=='('，则直接入栈
　　　　b.3:如果栈为空，则直接入栈
　　　　b.4:如果op的优先级高于栈顶操作符的优先级，则入栈
　　　　b.5:如果op的优先级低于或等于栈顶操作符的优先级，则依次弹出栈顶直到op的优先级高于栈顶操作符的优先级（或栈为空），再将op入栈
3、遍历完时，如果栈仍不为空，则依次弹出栈顶直到栈为空*/

    public static void main(String[] args) {

    }
    // https://programmercarl.com/0150.%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B1%82%E5%80%BC.html


}