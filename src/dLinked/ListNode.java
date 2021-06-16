package dLinked;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: ListNode
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/6/21 5:21 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class ListNode {


    int val;
    ListNode next;


    ListNode() {};
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
