package gLinked.aDelete;

import gLinked.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * todo 没有重复出现
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class cDeleteDuplicates {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(2,node2);
        ListNode node4 = new ListNode(4,node3);
        ListNode node5 = new ListNode(5,node4);

        ListNode listNode = deleteDuplicates(node5);
        System.out.println(listNode);
    }

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/
    /**
     * 删除排序链表中的重复元素
     * todo 双指针思想除了定义两个指针fast、slow外，还可以直接使用cur.next和cur.next.next
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head); //todo 引入哑节点
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next; //todo 删除了cur.next节点
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;

    }


}
