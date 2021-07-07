package dLinked;

/**
 * 删除排序链表中的重复元素
 */
public class fDeleteDuplicates {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(4,node3);
        ListNode node5 = new ListNode(5,node4);

        System.out.println(deleteDuplicates(node5).val);
    }




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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * 自己调试的
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesOfSelf (ListNode head) {
        // write code here

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur!= null && cur.next != null){
            int val = cur.val;
            while (cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;

            }
            if (cur.next!= null){
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    /////////////////////////////
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {       // todo 分支
                ListNode temp = curr.next;
                while (temp != null && temp.val == curr.val) {
                    temp = temp.next;
                }
                prev.next = temp;
                curr = temp;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }




}
