package gLinked.dDoublePointer.SpeedPointer;

import gLinked.ListNode;

import java.util.LinkedList;

/**
 * NC132 环形链表的约瑟夫问题
 *
 *  编号为 1 到 n 的 n 个人围成一圈。从编号为 1 的人开始报数，报到 m 的人离开。
 * 下一个人继续从 1 开始报数。
 * n-1 轮结束以后，只剩下一个人，问最后留下的这个人编号是多少？
 *
 * 数据范围： 1≤n,m≤100001 \le n , m \le 100001≤n,m≤10000
 * 进阶：空间复杂度 O(1)O(1)O(1)，时间复杂度 O(n)O(n)O(n)
 * 示例1
 * 输入：5,2
 * 返回值：3
 * 说明：
 * 开始5个人 1，2，3，4，5 ，从1开始报数，1->1，2->2编号为2的人离开
 * 1，3，4，5，从3开始报数，3->1，4->2编号为4的人离开
 * 1，3，5，从5开始报数，5->1，1->2编号为1的人离开
 * 3，5，从3开始报数，3->1，5->2编号为5的人离开
 * 最后留下人的编号是3
 */
public class jCrossJosephXXX {


    public static void main(String[] args){

        System.out.println(ysf(5,2));

    }

    // https://www.nowcoder.com/practice/41c399fdb6004b31a6cbb047c641ed8a?tpId=188&&tqId=38612&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    /**
     * 根据题意，正常构造链表满足条件删除即可
     * @param n
     * @param m
     * @return
     */
    public static int ysf (int n, int m) {
        // write code here
        ListNode head=new ListNode(1);
        ListNode tail=head;
        for(int i=2;i<=n;i++){
            tail.next=new ListNode(i);
            tail=tail.next;
        }
        tail.next=head;

        ListNode index=head;
        ListNode pre=tail;
        int k=0;

        while(index.next!=null&&index.next!=index){
            k++;
            ListNode next=index.next;
            if(k==m){ // todo
                pre.next=pre.next.next;
                k=0;
            }

            pre=index;
            index=next;
        }
        return index.val;
    }


    /////////////////////
    /**
     * 将[1,n]依次存储在链表中
     * 只要链表的长度不为1，就一直循环，如果到了第m个就remove；否则将其添加到链表尾部
     * 时间复杂度为O(nm)
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining(int n, int m){

        LinkedList<Integer> list=new LinkedList<>();
        if(m<1 || n<1){
            return -1;
        }

        for(int i=0;i<n;i++){
            list.add(i);
        }

        int bt=0;
        while(list.size()>1){
            bt=(bt+m-1)%list.size();
            list.remove(bt);
        }
        return list.get(0)+1;

    }


}
