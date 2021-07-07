package dLinked;

/**
 * 链表环
 */
public class iCrossLink {


    //理解 链表中环的入口结点 https://blog.nowcoder.net/n/9d3ffa4b004e43d1aff512141d0d7dac

    public static void main(String[] args){
        iCrossLink iCrossLink = new iCrossLink();
        int[] arr = {1,2,3,4,5,2};
        for (int i = 0; i< arr.length; i++){
            iCrossLink.addHead(arr[i]);
        }
        iCrossLink.print();

        Node node = iCrossLink.detectCrossNode();
        if (node == null){
            System.out.println("链表无环");
        }else {
            System.out.println("链表有环，快慢指针相遇节点"+node.data);
        }

        Node ringEntryNode = iCrossLink.getRingEntryNode();
        if (ringEntryNode == null){
            System.out.println("链表无环");
        }else {
            System.out.println("链表有环，入口节点"+ringEntryNode.data);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 判断是否有环，返回快慢指针相遇结点，否则返回空指针
     * @return
     */
    public Node detectCrossNode() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;  //todo 快指针走两步
            slow = slow.next;

            if (slow == fast) {
                return slow;
            }

        }
        return null;
    }


    /**
     * 找到入口结点
     * 要找到入口结点，只需定义两个指针，一个指针指向head，一个指针指向快慢指向的相遇点，
     * 然后这两个指针不断遍历(同时走一步)，当它们指向同一个结点时即是环的入口结点
     * @return
     */
    public Node getRingEntryNode() {
        // 获取快慢指针相遇结点
        Node crossNode = detectCrossNode();

        // 如果没有相遇点，则没有环
        if (crossNode == null) {
            return null;
        }

        // todo 分别定义两个指针，一个指向头结点，一个指向相交结点
        Node tmp1 = head;
        Node tmp2 = crossNode;

        // todo 两者相遇点即为环的入口结点
        while (tmp1.data != tmp2.data && tmp1.next != null && tmp2.next != null) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return tmp1;
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

    /**
     * 链表属性
     */
    private Node head;
    private int size;

    public iCrossLink(){
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
