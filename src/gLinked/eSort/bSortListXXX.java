package gLinked.eSort;

import gLinked.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 *     todo 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class bSortListXXX {

    // https://leetcode-cn.com/problems/sort-list/
    // https://www.cnblogs.com/du001011/p/10610522.html
    // https://blog.csdn.net/death05/article/details/103840704

    // todo 按照题目要求，在O(n log n)时间复杂度下，首先想到七大排序中的归并排序，因为快排的需要双指针，指向首尾，单链表后一个元素没有前一个元素指针。

    /**
     * 1.归并排序思想； 2.找到中间节点； 3.进行归并排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {

        return head == null ? head:mergeSort(head);
    }

    /**
     * 归并
     * @param head
     * @return
     */
    private static ListNode mergeSort(ListNode head) {

        if (head.next == null) {
            return head;
        }
        // 快慢指针找出中间结点，这块需要注意一点就是
        // 我们需要一个标记sign跟踪慢结点，当找出中间结点时，
        // todo 让中间结点前一结点即sign的下一个结点指向空 。这样做的目的是为了使前半部分链表和后半部分链表进行合并排序

        ListNode s = head;   // 慢结点
        ListNode f = head;  //快结点
        ListNode sign = null; //标记结点
        while (f.next != null) {
            sign = s;
            s = s.next;
            f = f.next.next;
        }
        //标记结点下一个结点为空
        sign.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(s);
        return merge(left, right);
    }

    /**
     * 合并两个链表
     * @param l
     * @param r
     * @return
     */
    public static ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }


    /////////////////////////////////////////////////////////////////////////////////
    public ListNode sortList1(ListNode head) {
        // 归并排序

        if (head == null || head.next == null) {
            return head;
        }

        // 先分隔，利用快慢指针分隔。
        // 快指针先走，因为只有当空节点或1个节点才是终止条件，2个节点的时候，如果不让快指针先走，而是也指向head，那么2个节点永远不会被分隔，会陷入死循环
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        // 后半部分的开头
        ListNode second = slow.next;
        second = sortList1(second);
        // 前半部分的开头
        slow.next = null;
        ListNode first = head;
        first = sortList1(first);

        // 合并
        ListNode result = new ListNode(0);
        head = result;
        while (first != null && second != null) {
            if (first.val < second.val) {
                result.next = first;
                first = first.next;
            } else {
                result.next = second;
                second = second.next;
            }
            result = result.next;
        }
        if (first != null) {
            result.next = first;
        } else {
            result.next = second;
        }

        return head.next;
    }



}
