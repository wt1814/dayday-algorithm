package dLinked;

/**
 * 不带头节点单向链表，递归反转链表
 */
public class dInvertLinkedListOfRecursion {


    public static void main(String[] args) {
        dInvertLinkedListOfRecursion linkedList = new dInvertLinkedListOfRecursion();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            linkedList.addHead(arr[i]);
        }
        linkedList.print();
        /*        ListNode newHead = linkedList.invertLinkedList(linkedList.head.next);
        // 翻转后别忘了设置头结点的后继结点！
        linkedList.head.next = newHead;*/
        Node newHead = linkedList.invertLinkedList(linkedList.head);
        //todo 翻转后别忘了设置头结点的后继结点！
        linkedList.head = newHead;
        linkedList.print(); // 打印 1，2，3，4
    }


    /**
     * 反转链表
     * @param node
     * @return
     */
    public Node invertLinkedList(Node node) {

        if (node.next == null) {
            return node;
        }

        // 步骤 1: 先翻转 node 之后的链表，得到头节点
        // todo 得到新的头节点
        Node newHead = invertLinkedList(node.next);
        // 步骤 2: 再把原 node 节点后继结点的后继结点指向 node (4)，node 的后继节点设置为空(防止形成环)
        node.next.next = node;  // 5 ---> 4， 1 ---> 2 ---> 3 ---> 4
        node.next = null;
        // 步骤 3: 返回翻转后的头结点
        return newHead;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 内部节点类
     */
    public class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // 属性
    private int size;
    private Node head;

    // 构造函数
    public dInvertLinkedListOfRecursion(){
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
