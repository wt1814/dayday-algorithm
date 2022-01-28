package jTree.aDFS.aAttribute;

import kTree.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 */
public class cCountNodes {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/dF04lAx-0jh59QRXtP7t9w
    /**
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {

        if(root == null) {  // todo 递归结束条件
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

}