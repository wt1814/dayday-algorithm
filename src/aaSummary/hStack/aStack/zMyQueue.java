package aaSummary.hStack.aStack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *     void push(int x) 将元素 x 推到队列的末尾
 *     int pop() 从队列的开头移除并返回元素
 *     int peek() 返回队列开头的元素
 *     boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *     你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 进阶：
 *     你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 *
 * 示例：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class zMyQueue {


    // 栈实现队列，用两个栈实现队列方法详解（含实现代码） http://data.biancheng.net/view/110.html

    public static void main(String[] args)throws Exception{

        zMyQueue zMyQueue = new zMyQueue();
        zMyQueue.push(1);
        zMyQueue.push(2);
        zMyQueue.push(3);

        System.out.println(zMyQueue.pop());
        System.out.println(zMyQueue.pop());
        System.out.println(zMyQueue.pop());
        System.out.println(zMyQueue.pop());

    }



    /**
     * todo 入队都在 stack1 中进行，出队在 stack2 中进行
     */
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    /**
     * todo 直接把元素压入 stack1 中
     * @param node
     */
    public void push(int node) {

        in.push(node);
    }

    /**
     * todo 如果 stack2 为空，则将 stack1 中的所有元素倒入 stack2 中，然后弹出 stack2 中的栈顶元素。
     * todo 若两个栈都为空栈，则队列为空队，无法出队。
     * todo 如果 stack2 不为空，则直接弹出 stack2 中的元素
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {

        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }

        if (out.isEmpty()){   //todo 若两个栈都为空栈，则队列为空队，无法出队。
            throw new Exception("queue is empty");
        }

        return out.pop();
    }



}
