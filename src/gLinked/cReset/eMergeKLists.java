package gLinked.cReset;

import gLinked.ListNode;
import java.util.ArrayList;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class eMergeKLists {


    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        return merge(lists,0,lists.size()-1);
    }

    // https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=188&&tqId=38611&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    // https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/

    /**
     *
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public ListNode merge(ArrayList<ListNode> lists, int l, int r){
        // 左右相等说明不能再分
        if(l == r){
            return lists.get(l);
        }
        if(l > r){
            return null;
        }

        int mid = l + (r-l)/2;
        ListNode merge = merge(lists, l, mid);
        ListNode merge1 = merge(lists, mid + 1, r);

        return mergeTwoList(merge,merge1);
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
