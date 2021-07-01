package dLinked;

/**
 * 划分链表
 */
public class lPartition {


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

        System.out.println(partition(node1,3).val);

    }

    // 给出一个链表和一个值 ，以 为参照将链表划分成两部分，使所有小于 的节点都位于大于或等于 的节点之前。
    //两个部分之内的节点之间要保持的原始相对顺序

    public static ListNode partition (ListNode head, int x) {
        // write code here
        if (head == null) return head;
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode n1 = h1;
        ListNode n2 = h2;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val < x) {
                n1.next = tmp;
                n1 = tmp;
            } else {
                n2.next = tmp;
                n2 = tmp;
            }
            tmp = tmp.next;
        }
        n2.next = null;
        n1.next = h2.next;
        return h1.next;
    }

}
