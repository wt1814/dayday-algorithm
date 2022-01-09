package aaSummary.hStack.bMonotoneStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class dDailyTemperatures {


    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(ints.toString());
    }



    // https://leetcode-cn.com/problems/daily-temperatures/solution/739-mei-ri-wen-du-dan-diao-zhan-xiang-ji-8kl5/



    ////////////////////////////////////////////////////////////////////////////////
    // https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
    /**
     * 遍历每日温度，维护一个单调栈：
     *
     * todo 若栈为空或者当日温度小于等于栈顶温度则直接入栈；
     * todo 反之，若当日温度大于栈顶温度，说明栈顶元素的升温日已经找到了，则将栈顶元素出栈，计算其与当日相差的天数即可。
     *
     * 注意题目要求的是升温的天数，而不是升温后的温度，因此栈中应该存储下标，而非温度。
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures1(int[] temperatures) {

        int[] ans = new int[temperatures.length];

        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;

    }

    ///////////////////////////////////////
    //https://leetcode-cn.com/problems/daily-temperatures/solution/java-739mei-ri-wen-du-dan-diao-zhan-xue-zup3o/
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        // 单调栈
        Deque<Integer> stack = new LinkedList<>();  //todo java中一般用Deque来代替Stack来实现栈, 本题栈存放数组下标 按从上往下元素递增顺序
        stack.push(0);
        for(int i=1;i<temperatures.length;i++){

            if(temperatures[i]<temperatures[stack.peek()]){         // 当前值小于栈顶，入栈
                stack.push(i);
            }
            else if(temperatures[i]==temperatures[stack.peek()]) {  // 当前值等于栈顶，入栈
                stack.push(i);
            }
            else{                                                   // todo todo todo 当前值大于栈顶，依次出栈比当前值小的元素
                while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){  // 注意stack不为空
                    ans[stack.peek()]=i-stack.peek();  // 更新ans
                    stack.pop();

                }
                stack.push(i);    //todo 该值还是要入栈

            }
        }
        return ans;

    }




}
