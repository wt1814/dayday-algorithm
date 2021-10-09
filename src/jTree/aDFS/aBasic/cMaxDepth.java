package jTree.aDFS.aBasic;

import jTree.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class cMaxDepth {


    // https://programmercarl.com/0104.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%A4%A7%E6%B7%B1%E5%BA%A6.html#%E9%80%92%E5%BD%92%E6%B3%95
    /**
     * 递归法
     */
    public int maxdepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = maxdepth(root.left);
        int rightdepth = maxdepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;

    }

}
