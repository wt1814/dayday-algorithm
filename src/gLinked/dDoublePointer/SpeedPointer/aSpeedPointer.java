package gLinked.dDoublePointer.SpeedPointer;

import gLinked.ListNode;

/**
 * 链表快慢指针找到单链表中间节点
 */
public class aSpeedPointer {

    public static void main(String[] args){


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 链表快慢指针找到中间节点
     * @return
     */
    public ListNode findMiddleNodeWithSlowFastPointer(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

}

