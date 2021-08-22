package aTest.day0805;

import gLinked.ListNode;

public class test2 {


    public static void main(String[] args){
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(2,node3);
        ListNode node5 = new ListNode(1,node4);

        ListNode listNode = reverseBetween(node5, 2, 4);
        System.out.println(listNode.val);
    }

    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;

        int num = 1;
        while(num <m){
            preNode = preNode.next;
            num++;
        }

        ListNode tempHead = preNode.next;
        ListNode cur = tempHead.next;
        ListNode next = null;
        while(num <=n){
            next = cur.next;
            cur.next = tempHead;
            tempHead = cur;
            cur = next;
            preNode.next = tempHead;
            num++;
        }
        System.out.println(tempHead.val);
        System.out.println(cur.val);
        tempHead.next = cur;
        preNode.next = tempHead;
        return dummyNode.next;

    }
}
