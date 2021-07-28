package aTest.day0728;

import dLinked.ListNode;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/28/21 2:52 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test2 {

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);

        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode partition = partition(listNode1, 3);
        System.out.println(partition.val);


    }

    public static ListNode partition (ListNode head, int x) {
        // write code here

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smyd = small;
        ListNode layd = large;

        while (head!= null){
            if (head.val < x){
                smyd.next = head;
                smyd = smyd.next;
            }else {
                layd.next = head;
                layd = layd.next;
            }

            head = head.next;
        }

        smyd.next = large.next;
        return small.next;
    }

}
