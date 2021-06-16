package aTest.day0519rewrite;

import java.util.Stack;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: StackQueue
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/19/21 1:49 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
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


    Stack<Integer> in  = new Stack<>();
    Stack<Integer> out  = new Stack<>();

    public void push(int data){
        in.push(data);
    }


    public int pop()throws Exception{


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
