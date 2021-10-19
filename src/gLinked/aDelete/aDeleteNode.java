package gLinked.aDelete;

import gLinked.ListNode;

/**
 *
 */
public class aDeleteNode {

    // todo 链表删除节点的两种方式
    // https://blog.csdn.net/yc1203968305/article/details/79278268
    // 1、如上图中的( b)所示：要删除i结点，必须从头扫描，扫到h(i的前一个结点),然后让其next值指向j(i的下一个位置)，然后就可以删除i了。
    // 此方法的复杂度为O（n）,因为要删除某个结点必须找到其上一个结点，故需要从头遍历。

    // todo 2、如上图中的（c）所示：要删除i结点，可以先把i的下一节点的值赋给i结点，然后让i的next值指向下一节点的下一结点，就相当于删除i结点。
    // （注意要保存i->next的这个结点，然后再删除），此算法复杂度为O(1),但是必须要求此要删除结点一定是链表中的结点，
    // 且当要删除的结点为最后一个结点时，必须用第一种方法，顺序遍历后找到最后一结点的上一结点，然后删除，
    // 但此方法的平均时间复杂度仍然为O(1).


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
