package gLinked.bReversal;

/**
 * 不带头节点单向链表，双指针迭代反转链表
 * todo 指针反转
 */
public class aInvertLinkedListOfIterate {

    public static void main(String[] args) {

        aInvertLinkedListOfIterate linkedList = new aInvertLinkedListOfIterate();
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
     * 在遍历链表时，将当前节点的 next指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     * @param head
     * @return
     */
    public Node reverseList(Node head) {

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            /**
             * 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
             * 也就无法对 cur 后继之后的结点进行翻转了
             */
            Node next = curr.next;   // todo 保存当前节点的下一节点
            curr.next = prev;   // todo 反转
            // todo 矫正pre 和 cur 以便下一次
            prev = curr;  curr = next;
        }
        return prev;

    }




    //////////////////////////////

    /**
     * 迭代解反转链表
     */
    public void iterationInvertLinkedList() {
        // 步骤 1
        Node pre = head;
        Node cur = pre.next;
        pre.next = null;  //todo 首先断开头节点和后继节点

        while (cur != null) {
            /**
             * 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
             * 也就无法对 cur 后继之后的结点进行翻转了
             */
            Node next = cur.next; // todo 保存当前节点的下一节点

            cur.next = pre; // todo 反转
            // todo 矫正pre 和 cur 以便下一次
            pre = cur;   cur = next;
        }
        // 此时 pre 为头结点的后继结点
        head = pre;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////

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


    // 属性
    private int size;
    private Node head;

    // 构造函数
    public aInvertLinkedListOfIterate(){
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
