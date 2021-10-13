package gLinked.cReset;

import gLinked.ListNode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * todo 链表分割
 */
public class bOddEvenList {

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = oddEvenList(node1);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);

    }


    /**
     *
     * @param head
     * @return
     */
    public ListNode oddEvenListOfSelf (ListNode head) {
        // write code here

        if(head == null){
            return null;
        }

        ListNode ji = head;  // 定义新的奇链表的头节点
        ListNode ou = head.next;  // 定义新的偶链表的头节点

        ListNode jiYiDong = ji; //todo 哨兵节点，即移动节点
        ListNode ouYiDong = ou;

        while(ouYiDong != null && ouYiDong.next != null ){
            jiYiDong.next = ouYiDong.next;
            jiYiDong = jiYiDong.next;
            ouYiDong.next = jiYiDong.next;
            ouYiDong = ouYiDong.next;
        }

        jiYiDong.next = ou;
        return ji;
    }

    // https://leetcode-cn.com/problems/odd-even-linked-list/solution/
    /**
     * 对于原始链表，每个节点都是奇数节点或偶数节点。头节点是奇数节点，头节点的后一个节点是偶数节点，相邻节点的奇偶性不同。因此可以将奇数节点和偶数节点分离成奇数链表和偶数链表，然后将偶数链表连接在奇数链表之后，合并后的链表即为结果链表。
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next; //todo 记录偶数链表的头节点

        ListNode odd = head; //todo 基数链表的移动节点
        ListNode even = evenHead; //todo 偶数链表的移动节点

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
