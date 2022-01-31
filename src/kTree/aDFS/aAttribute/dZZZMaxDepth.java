package kTree.aDFS.aAttribute;

import lTree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class dZZZMaxDepth {


    public static void main(String[] args) {

    }

    // https://programmercarl.com/0104.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%A4%A7%E6%B7%B1%E5%BA%A6.html#%E9%80%92%E5%BD%92%E6%B3%95
    /**
     * 递归法
     */
    public static int maxdepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftdepth = maxdepth(root.left);
        int rightdepth = maxdepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;

    }

}
