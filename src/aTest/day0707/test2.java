package aTest.day0707;

import dLinked.ListNode;

public class test2 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        listNode1.next = listNode2;
        //listNode2.next = listNode3;

        ListNode listNode = deleteDuplicates(listNode1);
        System.out.println("5555555555");

    }
    public static ListNode deleteDuplicates (ListNode head) {
        // write code here

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur!= null && cur.next != null){
            int val = cur.val;
            while (cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;

            }
            if (cur.next!= null){
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
