package aTest.day0517rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: bInvertLinkedList
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 5/17/21 10:22 AM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class InvertLinkedList {

    public static void main(String[] args) {
        InvertLinkedList linkedList = new InvertLinkedList();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            linkedList.addHeadNode(arr[i]);
        }
        linkedList.print();
        System.out.println("-------");
        /*        ListNode newHead = linkedList.invertLinkedList(linkedList.head.next);
        // 翻转后别忘了设置头结点的后继结点！
        linkedList.head.next = newHead;*/
        Node newHead = linkedList.inverLinkedList(linkedList.head);
        // 翻转后别忘了设置头结点的后继结点！
        linkedList.head = newHead;
        linkedList.print(); // 打印 1，2，3，4
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
    public InvertLinkedList(){
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

    /**
     * 递归反转链表
     * @param node
     * @return
     */
    public Node inverLinkedList(Node node){
        if (node.next == null){
            return node;  //返回末尾节点
        }

        Node node1 = inverLinkedList(node.next);
        node.next.next = node;
        node.next = null;

        return node1;

    }


}
