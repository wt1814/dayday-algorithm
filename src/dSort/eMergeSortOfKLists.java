package dSort;

import gLinked.ListNode;
import java.util.ArrayList;

/**
 * 合并k个已排序的链表
 */
public class eMergeSortOfKLists {

    /**
     * 合并k个已排序的链表并将其作为一个已排序的链表返回。
     * 分析并描述其复杂度。---熟悉mergeSort,返回值不同！！当low>=high,则说明有序，直接返回lists.get(low)
     * @param lists k个已排序的链表
     * @return 一个已排序的链表
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null||lists.size()==0){
            return null;
        }
        return mergeKLists(lists,0,lists.size()-1);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists, int low, int high){
        if(low>=high){
            return lists.get(low);
        }
        int mid=low+(high-low)/2;
        ListNode l1=mergeKLists(lists,low,mid);
        ListNode l2=mergeKLists(lists,mid+1,high);
        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }

    }

}
