package gLinked.aDelete;

import gLinked.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class bRemoveNthFromEnd {


    public static void main(String[] args) {

    }


    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * 删除链表倒数第n个节点。转化为快慢指针找到第n+1个节点，并且删除其后继节点
     * @param head
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0); //todo 哑节点
        dummy.next = head;
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * 获取链表的长度
     * @param head
     * @return
     */
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
    // 删除链表倒数第N个节点
    /**
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode removeNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); //todo 引入哑节点
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    ////////////////////////////////////////////////////////////////////////////////////


    // https://blog.csdn.net/weixin_43954926/article/details/104256795
    /**
     * //todo 错误
     * 双指针删除倒数第N个节点
     * @param listNode
     * @param n
     * @return
     */
    private ListNode removeNodeByEndNum(ListNode listNode, int n) {
        //初始化两个指针
        ListNode beforePointer = listNode;
        ListNode afterPointer = listNode;
        //第一个指针向前一定n个节点
        while (n>0){
            //当n>链表长度时，直接返回原链表
            if (beforePointer == null){
                return listNode;
            }
            beforePointer = beforePointer.next;
            n--;
        }
        //当第一个指针遍历结束后，第二个指针指向的位置即为要删除的节点
        while (beforePointer != null && beforePointer.next != null){
            beforePointer = beforePointer.next;
            afterPointer = afterPointer.next;
        }
        //根据第二个指针指向的位置删除节点
        //如果不喜用该if-else，可以通过在链表起始位置增加空节点来解决
        if (listNode == afterPointer){
            //如果第二个指针位置没有变动则需要删除起始节点
            listNode = listNode.next;
        }else {
            afterPointer.next = afterPointer.next.next;
        }
        return listNode;
    }


}
