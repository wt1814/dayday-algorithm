package dLinked;

/**
 * 不带头节点单向链表，双指针迭代反转链表
 */
public class cInvertLinkedList {


    public static void main(String[] args) {

        cInvertLinkedList linkedList = new cInvertLinkedList();
        int[] arr = {1, 2, 3, 4,5};
        for (int i = 0; i < arr.length; i++) {
            linkedList.addHead(arr[i]);
        }
        linkedList.print();
        linkedList.iterationInvertLinkedList();
        // 翻转后别忘了设置头结点的后继结点！
        //linkedList.head = newHead;
        linkedList.print(); // 打印 1，2，3，4
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
    public class Node{
        private int data;
        private Node next;

        public Node(){

        }
        public Node(int data){
            this.data = data;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // 属性
    private int size;
    private Node head;

    // 构造函数
    public cInvertLinkedList(){
/*        ListNode node = new ListNode();
        node.next = null;
        head = node;*/
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

        Node newHead = new Node(obj);
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
