package aaSummary.gLinked.bReversal;

import gLinked.ListNode;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 *     你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *     你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class dZZZReverseKGroup {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(4,node3);
        ListNode node5 = new ListNode(5,node4);

        ListNode listNode = reverseKGroup1(node5, 3);
        System.out.println(listNode.val);

    }


    // https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=188&&tqId=38557&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup1 (ListNode head, int k) {

        if(head==null || head.next==null || k==1) {
            return head;
        }

        ListNode res = new ListNode(0);
        res.next = head;
        int length = 0;
        ListNode pre = res,
                cur = head,
                temp = null;

        while(head!=null){
            length++;
            head = head.next;
        }

        /**
         * todo 分段使用头插法将链表反序
         */
        for(int i=0; i<length/k; i++){
            //todo todo todo pre作为每一小段链表的头节点，负责衔接
            for(int j=1; j<k; j++){
                temp = cur.next;
                cur.next = temp.next;
                //todo todo todo 相当于头插法，
                // 注意：temp.next = cur是错误的，temp需要连接的不是前一节点，而是子序列的头节点
                temp.next = pre.next;
                pre.next = temp;
            }
            //todo todo todo 每个子序列反序完成后，pre，cur需要更新至下一子序列的头部
            pre = cur;
            cur = cur.next;
        }
        return res.next;

    }

    ////////////////////////////////////////////////////////////////////
    // https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
    public static ListNode reverseKGroup2(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            // todo 记录开始节点与下一组的开始节点
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre; // todo 更新下标，进行下一轮循环
        }
        return dummy.next;

    }

    private static ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

}
