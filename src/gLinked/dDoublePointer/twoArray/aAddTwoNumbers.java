package gLinked.dDoublePointer.twoArray;

import gLinked.ListNode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class aAddTwoNumbers {

    // https://leetcode-cn.com/problems/add-two-numbers/

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 5;
        ListNode l2 = new ListNode();
        l2.val = 6;
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newListNode = new ListNode();
        ListNode curListNode = newListNode;
        int mark = 0;

        while(l1 != null || l2 != null || mark == 1){
            int a1 = 0;
            if(l1 != null){
                a1 = l1.val;
                l1 = l1.next;
            }

            int a2 = 0;
            if(l2 != null){
                a2 = l2.val;
                l2 = l2.next;
            }

            int sum = a1 + a2 + mark;
            mark = sum/10;

            curListNode.next = new ListNode();
            curListNode = curListNode.next;
            curListNode.val = sum % 10;
        }

        return newListNode.next;
    }


}
