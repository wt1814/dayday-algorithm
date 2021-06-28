package dLinked;

/**
 *
 */
public class eDeleteNode {



    // https://www.cnblogs.com/guohai-stronger/p/11981565.html

    /**
     * todo @param node 题目给的是删除节点，那说明这个节点可以舍弃了，
     * todo 把下一个节点的值拷贝给当前要删除的节点，再删除下一个节点。
     * @param node 要删除的节点
     */
    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
