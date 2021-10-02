package gLinked.cReset;

import gLinked.ListNode;

/**
 * 划分链表
 * 给出一个链表和一个值，以特定值为参照将链表划分成两部分，使所有小于 的节点都位于大于或等于 的节点之前。
 */
public class partition {


    public static void main(String[] args){
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);

        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode partition = partition(listNode1, 3);
        System.out.println(partition.val);

    }

    /**
     *
     * @param head ListNode类
     * @param x int整型
     * @return ListNode类
     */
    public static ListNode partition (ListNode head, int x) {

        // write code here
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smyd = small;
        ListNode layd = large;

        while (head!= null){
            if (head.val < x){
                smyd.next = head;
                smyd = smyd.next;
            }else {
                layd.next = head;
                layd = layd.next;
            }
            head = head.next;
        }
        layd.next = null; //todo 对链表进行指空处理
        smyd.next = large.next;
        return small.next;

    }

}
