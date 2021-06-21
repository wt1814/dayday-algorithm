package eStack;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class cStackQueue {


    // 栈实现队列，用两个栈实现队列方法详解（含实现代码） http://data.biancheng.net/view/110.html

    public static void main(String[] args)throws Exception{

        cStackQueue cStackQueue = new cStackQueue();
        cStackQueue.push(1);
        cStackQueue.push(2);
        cStackQueue.push(3);

        System.out.println(cStackQueue.pop());
        System.out.println(cStackQueue.pop());
        System.out.println(cStackQueue.pop());
        System.out.println(cStackQueue.pop());
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

        if (out.isEmpty()){
            throw new Exception("queue is empty");
        }

        return out.pop();
    }
}
