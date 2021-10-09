package hStack.stack;

import java.util.Stack;

/**
 * 438，剑指 Offer-栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class aValidateStackSequences {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247488354&idx=1&sn=817a2e26f448dff247c0ceb519cca92f&chksm=fb418042cc360954f79fefd439b5d9f8fc9cc52836a70306166011643d77eab987215bab503c&scene=21#wechat_redirect
    /**
     * 一种解决方式就是把pushed数组的元素逐个压栈，当栈顶元素等于popped数组中第一个元素的时候，就让栈顶元素出栈，这个时候再用popped数组的第2个元素和栈顶元素比较，如果相同继续出栈……，最后判断栈是否为空即可。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int val : pushed) {
            //pushed数组中的元素逐个压栈
            stack.push(val);
            while (!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }

}
