package jTree.bBFS;

import jTree.TreeNode;
import java.util.*;

/**
 * 层序遍历
 */
public class aLevelOrderTraversal {

    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        List<List<Integer>> lists = levelOrder(treeNode1);
        for (List<Integer> list:lists){
            for (Integer integer:list){
                System.out.print(integer+" ");
            }
        }

        System.out.println("------------------------------");

        level(treeNode1);
    }

    /* todo
    算法分析
        层序遍历与先序、中序、后序遍历不同。层序遍历用到了队列，而先、中、后序需要用到栈。
        因此，先、中、后序遍历 可以 采用递归方式来实现，而层序遍历则没有递归方式。

    算法步骤：
        初始时，根结点入队列
        然后，while循环判断队列不空时，弹出一个结点，访问它，并把它的所有孩子结点入队列。
    */

    /**
     * 层序遍历
     * 类似前序遍历，借用队列数据结构， 1). 弹就打印； 2). 如有左，压入左；3). 如有右，压入右
     * @param root
     */
    public static void level(TreeNode root){

        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>(); //todo 创建队列，使用链表这种队列
        queue.add(root); //todo 队列里放入TreeNode

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " "); // 弹就打印
            if (cur.left != null){    // todo 队列弹出对节点
                queue.add(cur.left);  // todo 如有左，压入左
            }
            if (cur.right != null){
                queue.add(cur.right); // todo 如有右，压入右
            }
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 结果集
        List result = new ArrayList();
        // 待遍历的层级节点列表
        LinkedList<TreeNode> list = new LinkedList();

        if (root != null) {
            list.add(root);
        }

        int size = list.size();
        while (size > 0) {
            // 创建保存当前层序的结果集列表
            List item = new ArrayList();
            // 遍历当前层序，加入结果集及获取下一层级的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = list.remove();
                item.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            size = list.size();
            System.out.println(size);
            for (int i = 0;i<item.size();i++){
                System.out.println(item.get(i));
            }

            result.add(item);
        }
        return result;
    }


}
