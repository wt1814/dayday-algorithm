package aaSummary.gLinked.bReversal;

import gLinked.ListNode;

/**
 * 92. 反转链表 II
 * NC21：链表内指定区间反转
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
 * todo 将待移动节点移动到前驱节点后，类似头插法
 */
public class cZZZReverseBetween {


    public static void main(String[] args) {

        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseBetween(node, 2, 4);
        System.out.println(listNode.val);

    }


    // https://blog.nowcoder.net/n/d59591b9e85344ceac8a6bab0e9849ed
    /**
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween (ListNode head, int m, int n) {

        // write code here
        // 设置哑节点的好处：
        //在m=1时，我们也有前驱节点，也可以将cur的next节点依次插入到pre的后面
        ListNode dummy=new ListNode(-1); // todo 哑节点
        dummy.next=head;
        ListNode pre=dummy;
        // 找到m的前驱节点
        for(int i=1;i<m;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        // todo todo todo 每次循环将tmp节点插入到pre的后面
        for(int i=m;i<n;i++){
            ListNode tmp=cur.next;
            cur.next=tmp.next;// cur将tmp节点后面的链表连接起来
            tmp.next=pre.next;// todo 将tmp插入到pre后面
            pre.next=tmp;
        }
        //例如0->1->2->3->4->5->6->7->8->9->10,翻转2--8；
        // 第1次i=2：0->1->3->2->4->5->6->7->8->9->10
        // 第2次i=3：0->1->4->3->2->5->6->7->8->9->10
        // 第3次i=4：0->1->5->4->3->2->6->7->8->9->10
        // 第4次i=5：0->1->6->5->4->3->2->7->8->9->10
        // 第5次i=6：0->1->7->6->5->4->3->2->8->9->10
        // 第6次i=7：0->1->8->7->6->5->4->3->2->9->10
        return dummy.next;

    }

}
