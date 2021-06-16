package aTest.day0517rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: aInvertLinkedList2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/17/21 10:55 AM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class InvertLinkedList2 {

    public static void main(String[] args) {
        InvertLinkedList2 linkedList = new InvertLinkedList2();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            linkedList.addHeadNode(arr[i]);
        }
        linkedList.print();
        System.out.println("-------");
        /*        ListNode newHead = linkedList.invertLinkedList(linkedList.head.next);
        // 翻转后别忘了设置头结点的后继结点！
        linkedList.head.next = newHead;*/
        linkedList.inverLinkedList();
        // 翻转后别忘了设置头结点的后继结点！
        linkedList.print(); // 打印 1，2，3，4
    }



    /**
     * 递归反转链表
     * @return
     */
    public void inverLinkedList(){
        Node pre = head;
        Node cur = pre.next;
        pre.next = null;

        while (cur != null) {
            /**
             * 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
             * 也就无法对 cur 后继之后的结点进行翻转了
             */
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时 pre 为头结点的后继结点
        head = pre;
    }



        /**
         * 迭代反转链表
         */
    public void iterationInvertLinkedList() {
        // 步骤 1
        Node pre = head;
        Node cur = pre.next;
        pre.next = null;

        while (cur != null) {
            /**
             * 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
             * 也就无法对 cur 后继之后的结点进行翻转了
             */
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时 pre 为头结点的后继结点
        head = pre;
    }


    /**
     * 内部节点类
     */
    private class Node{
        private int data;
        private Node next;

        // 构造函数
        public Node(){

        }
        public Node(int data){
            this.data = data;
        }

    }


    private Node head;
    private int size;

    /**
     * 构造函数
     */
    public InvertLinkedList2(){
        this.head = null;
        this.size = 0;
    }

    /**
     * 添加头节点
     * @param data
     * @return
     */
    public Node addHeadNode(int data){
        Node newHead = new Node(data);
        if (size == 0){
            head = newHead;
        }else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return newHead;
    }

    /**
     * 打印节点
     */
    public void print() {
        Node current = head;
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
