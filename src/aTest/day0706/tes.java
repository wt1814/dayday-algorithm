package aTest.day0706;

import dLinked.ListNode;

public class tes {

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;

        ListNode listNode = removeNthFromEnd(listNode2, 1);
        System.out.println("111");
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null){
            slow.val = slow.next.val;
        }else {
            dummy.next = null;
            return dummy.next;
        }
        if(slow.next != null && slow.next.next != null){
            slow.next = slow.next.next;
        }else{
            slow.next = null;
        }
        return dummy.next;
    }

}
