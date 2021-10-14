package jTree.aDFS.depth;

import jTree.TreeNode;

/**
 * 111. 二叉树的最小深度
 */
public class cMinDepth {

    // https://programmercarl.com/0111.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E6%B7%B1%E5%BA%A6.html
    // https://mp.weixin.qq.com/s/WJj7rNR8I2gT3mKllP--VQ

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        //如果左子树等于空，我们返回右子树的最小高度+1
        if (root.left == null)
            return minDepth(root.right) + 1;
        //如果右子树等于空，我们返回左子树的最小高度+1
        if (root.right == null)
            return minDepth(root.left) + 1;
        //如果左右子树都不为空，我们返回左右子树深度最小的那个+1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }



}
