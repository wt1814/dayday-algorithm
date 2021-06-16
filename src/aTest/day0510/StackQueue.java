package aTest.day0510;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class StackQueue {

    public static void main(String[] args)throws Exception{
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

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
