package hStack.monotoneStack;

import gLinked.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * 示例 1：
 * 输入：[2,1,5]
 * 输出：[5,5,0]
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
        //栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的值是从大到小的
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
