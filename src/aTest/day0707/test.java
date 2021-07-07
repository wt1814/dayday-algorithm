package aTest.day0707;

import dLinked.ListNode;

public class test {


    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        listNode1.next = listNode2;

        ListNode listNode = removeNthFromEnd(listNode1, 1);
        System.out.println("5555555555");

    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null){
            return null;
        }

        int length = getLength(head);

        if(n> length){
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0;i<length-n;i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return dummyNode.next;
    }

    public static int getLength(ListNode head){
        int result = 1;
        while(head.next != null){
            head = head.next;
            result++;
        }
        return result;
    }

}
