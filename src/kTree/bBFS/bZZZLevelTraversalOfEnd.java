package kTree.bBFS;

import java.util.LinkedList;
import java.util.Queue;

import lTree.TreeNode;

/**
 * 层序遍历，每一层结束
 * todo 判断每一层结束
 */
public class bZZZLevelTraversalOfEnd {

    // https://blog.csdn.net/OrthocenterChocolate/article/details/37612183

    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        level(treeNode1);
    }

    /**
     * 层序遍历
     * 类似前序遍历，借用队列数据结构， 1). 弹就打印； 2). 如有左，压入左；3). 如有右，压入右
     * @param root
     */
    public static void level(TreeNode root){

        if (root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root); //todo 放入到队列的是节点TreeNode类型
        queue.add(null); //todo 一层结束放入null节点
        int level = 1;

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(null == cur?" ":cur.val+" "); // 弹就打印

            //todo 弹出为null节点，说明本层结束，同时下一层也全部放入了队列中，再次添加null节点
            if (null == cur){

                if (queue.isEmpty()){  // todo todo 特例：如果队列中已经没有数据，则说明遍历已经结束，需要停止循环
                    break;   //todo 如果无此句，则会死循环
                }

                System.out.println("第"+level+"层结束");
                level++;
                queue.add(null);
                continue;  // todo 跳出循环
            }

            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        level++;
    }

}
