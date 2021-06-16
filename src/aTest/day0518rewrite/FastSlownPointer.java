package aTest.day0518rewrite;


/**
 * 快慢指针找中间节点
 */
public class FastSlownPointer {


    public static void main(String[] args){

        FastSlownPointer fastSlownPointer = new FastSlownPointer();
        int[] arr = {1,2,3,4,5};
        for (int i = 0;i<arr.length;i++){
            fastSlownPointer.addHead(arr[i]);

        }
        fastSlownPointer.print();

        Node node = fastSlownPointer.middlePoint();
        System.out.println(node.data);


    }


    public Node middlePoint(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 内部节点类
     */
    private class Node{
        private int data;
        private Node next;

        public Node(){

        }
        public Node(int data){
            this.data = data;
        }
    }

    /**
     * 属性
     */
    private Node head;
    private int size;

    /**
     * 构造函数
     */
    public FastSlownPointer(){
        this.head = null;
        this.size = 0;
    }
    public FastSlownPointer(Node head, int size){
        this.head = head;
        this.size = 0;
    }


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
