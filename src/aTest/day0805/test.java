package aTest.day0805;

import gLinked.ListNode;

public class test {

    public static void main(String[] args){

    }

    public static ListNode Merge(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        while(list1.next != null && list2.next != null){
            if(list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
                pre = pre.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
                pre = pre.next;
            }
        }

        if(list1 != null){
            pre.next = list1;
        }else{
            pre.next = list2;
        }

        return dummyNode.next;

    }
}
