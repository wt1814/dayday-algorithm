package hStack.stack;

import java.util.Stack;

/**
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
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
