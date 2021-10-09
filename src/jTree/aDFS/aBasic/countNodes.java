package jTree.aDFS.aBasic;

import jTree.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 */
public class countNodes {


    // 通用递归解法
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
