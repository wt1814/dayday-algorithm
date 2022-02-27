package aaSummary.gLinked.bReversal;

import gLinked.ListNode;

/**
 * 不带头节点单向链表，双指针迭代反转链表
 * todo 指针反转
 */
public class aInvertLinkedListOfIterate {

    public static void main(String[] args) {


    }

    /**
     * 在遍历链表时，将当前节点的 next指针改为指向前一个节点。
     * todo 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            /**
             * todo todo todo 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
             * 也就无法对 cur 后继之后的结点进行翻转了
             */
            ListNode next = curr.next;   // todo 保存当前节点的下一节点
            curr.next = prev;   // todo 反转
            // todo 矫正pre 和 cur 以便下一次
            prev = curr;  curr = next;

/*                    # 留下联系方式
                    next = cur.next
                    # 修改指针
                    cur.next = pre
                    # 继续往下走
                    pre = cur
                    cur = next*/
        }
        return prev;

    }

    ////////////////////////////////////////////////////////////////

    /**
     * 迭代解反转链表
     */
    public void iterationInvertLinkedList(ListNode head) {

        // 步骤 1
        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;  //todo 首先断开头节点和后继节点

        while (cur != null) {
            /**
             * 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
             * 也就无法对 cur 后继之后的结点进行翻转了
             */
            ListNode next = cur.next; // todo 保存当前节点的下一节点

            cur.next = pre; // todo 反转
            // todo 矫正pre 和 cur 以便下一次
            pre = cur;   cur = next;
        }
        // 此时 pre 为头结点的后继结点
        head = pre;

    }

}
