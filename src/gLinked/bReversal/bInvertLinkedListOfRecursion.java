package gLinked.bReversal;

import gLinked.ListNode;

/**
 * 不带头节点单向链表，递归反转链表
 */
public class bInvertLinkedListOfRecursion {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newHead = invertLinkedList(node1);
        //todo 翻转后别忘了设置头结点的后继结点！
    }


    /**
     * 反转链表
     * @param node
     * @return
     */
    public static ListNode invertLinkedList(ListNode node) {

        if (node.next == null) {
            return node;
        }

        // 步骤 1: 先翻转 node 之后的链表，得到头节点
        // todo 得到新的头节点
        ListNode newHead = invertLinkedList(node.next);
        // 步骤 2: 再把原 node 节点后继结点的后继结点指向 node (4)，node 的后继节点设置为空(防止形成环)
        node.next.next = node;  // 5 ---> 4， 1 ---> 2 ---> 3 ---> 4
        node.next = null;
        // 步骤 3: 返回翻转后的头结点
        return newHead;

    }


}
