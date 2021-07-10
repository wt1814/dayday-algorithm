package dLinked;

/**
 * 链表的奇偶重排
 */
public class oOddEvenList {



    public ListNode oddEvenList (ListNode head) {
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
}
