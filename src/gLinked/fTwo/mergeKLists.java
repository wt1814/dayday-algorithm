package gLinked.fTwo;

import gLinked.ListNode;

import java.util.ArrayList;

/**
 * 合并k个已排序的链表 https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=188&&tqId=38611&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 *
 */
public class mergeKLists {


    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        return merge(lists,0,lists.size()-1);
    }

    /**
     *
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public ListNode merge(ArrayList<ListNode> lists, int l, int r){
        // 左右相等说明不能再分
        if(l == r)
            return lists.get(l);
        if(l > r){
            return null;
        }
        int mid = l + (r-l)/2;
        return mergeTwoList(merge(lists,l,mid),merge(lists,mid+1,r)); //todo
    }

    /**
     * 合并两个有序链表
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeTwoList(ListNode node1, ListNode node2){
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while(node1!=null && node2!=null){
            if(node1.val <= node2.val){
                tmp.next = node1;
                node1 = node1.next;
            }else{
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = node1!=null?node1:node2;
        return node.next;
    }

}
