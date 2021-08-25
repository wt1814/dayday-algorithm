package gLinked.aDelete;

/**
 * 删除链表节点
 */
public class eRemoveNthFromEnd {

    public static void main(String[] args) {
        eRemoveNthFromEnd eRemoveNthFromEnd = new eRemoveNthFromEnd();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            eRemoveNthFromEnd.addHead(arr[i]);
        }
        eRemoveNthFromEnd.print();

        eRemoveNthFromEnd.removeNodeByEndNum(eRemoveNthFromEnd.head,2);
        eRemoveNthFromEnd.print(); // 打印 1，2，3，4

        eRemoveNthFromEnd.removeNthFromEnd(eRemoveNthFromEnd.head,1);
        eRemoveNthFromEnd.print(); // 打印 1，2，3，4
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
     * @param listNode
     * @param n
     * @return
     */
    private ListNode removeNode(ListNode listNode, int n) {
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






    ////////////////////////////////////////////////////////////////////////

    /**
     * 内部节点类
     */
    public class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }

        ListNode(int val, ListNode next) { this.data = val; this.next = next; }
    }

    /**
     * 链表属性
     */
    private ListNode head;
    private int size;

    public eRemoveNthFromEnd(){
        this.head = null;
        this.size = 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 在链表头节点添加元素
     * @param obj
     * @return
     */
    private Object addHead(int obj){

        ListNode newHead = new ListNode(obj);
        if (size == 0){
            head = newHead;
        }else {
            newHead.next = head;
            head = newHead;
        }
        size ++;
        return newHead;

    }

    /**
     * 打印节点
     */
    public void print() {
        ListNode current = head;
        while (current!=null){
            if(current.next!=null)
                System.out.print(current.data+"->");
            else {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }

}
