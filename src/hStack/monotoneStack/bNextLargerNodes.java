package hStack.monotoneStack;

import gLinked.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 386，链表中的下一个更大节点
 */
public class bNextLargerNodes {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487313&idx=1&sn=5643ba3fd45550efe5259d7881c77baf&chksm=fb419c71cc3615675fa5fa628efa87fcf29911186e7e92c04cb4a071b573ee1a1859e9a2a38b&scene=21#wechat_redirect
    /**
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        //栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的
        //值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.empty() && list.get(stack.peek()) < list.get(i)) {
                //如果栈顶元素对应的值小于当前值，说明栈顶元素遇到了比他小的
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

}
