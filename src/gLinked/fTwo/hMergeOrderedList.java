package gLinked.fTwo;

import gLinked.ListNode;

/**
 * 合并两个有序链表
 * 要求重复利用已有空间
 * todo 移动节点 和 哨兵节点 的使用
 */
public class hMergeOrderedList {

    public static void main(String[] args){
        ListNode listNode = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode);
        ListNode listNode3 = new ListNode(3, listNode2);

        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(8, listNode6);
        ListNode listNode8 = new ListNode(2, listNode7);

        ListNode listNode9 = mergeTwoLists(listNode3, listNode8);

        ListNode listNode1 = mergeTwoListsBy(listNode3, listNode8);
        System.out.println(listNode1.next.next.next.val);
    }


    //todo https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/

    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1); // todo 哑节点
        ListNode prev = prehead;  // todo 哨兵节点

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next; // todo 哨兵节点也要移动
        }

        //todo 合并后 l1 和 l2 最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可
        if (l1 != null){
            prev.next = l1;
        }else {
            prev.next = l2;
        }

        return prehead.next;
    }

    /**
     * 递归解
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsBy(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsBy(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsBy(l1, l2.next);
            return l2;
        }
    }

}
