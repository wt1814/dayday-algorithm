package aTest.day0608rewrite;


public class eMergeOrderedList {

    public static void main(String[] args){
        ListNode listNode = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode);
        ListNode listNode3 = new ListNode(3, listNode2);


        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(8, listNode6);
        ListNode listNode8 = new ListNode(2, listNode7);


        ListNode listNode9 = mergeTwoListsBy(listNode3, listNode8);

        System.out.println(listNode9.val);
    }


    public static ListNode mergeTwoListsBy(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(-1);

        ListNode pre = newHead;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return newHead.next;
    }


}
