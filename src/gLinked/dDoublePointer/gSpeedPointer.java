package gLinked.dDoublePointer;

/**
 * 链表快慢指针找到单链表中间节点
 */
public class gSpeedPointer {

    public static void main(String[] args){

        gSpeedPointer gSpeedPointer = new gSpeedPointer();
        int arr[] = {1,2,3,4};

        for (int i = 0 ; i < arr.length; i++){
            gSpeedPointer.addHead(arr[i]);
        }
        gSpeedPointer.print();
        Node middleNodeWithSlowFastPointer = gSpeedPointer.findMiddleNodeWithSlowFastPointer();
        System.out.println(middleNodeWithSlowFastPointer.data);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 链表快慢指针找到中间节点
     * @return
     */
    public Node findMiddleNodeWithSlowFastPointer(){

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

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

    /**
     * 链表属性
     */
    private Node head;
    private int size;

    public gSpeedPointer(){
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
            if(current.next!=null){
                System.out.print(current.data+"->");
            }
            else {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }

}

