package jTree.aDFS.aBasic;

import jTree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {


    // https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
    // https://mp.weixin.qq.com/s/aWvfcCh4JjWxJVWpyr2WmQ
    // https://mp.weixin.qq.com/s/V73MWneaud5A97j_Ltxnmw
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {

        return CommonAncestor(root, o1, o2).val;
    }


    public TreeNode CommonAncestor (TreeNode root, int o1, int o2) {

        if (root == null || root.val == o1 || root.val == o2) { // 超过叶子节点，或者root为p、q中的一个直接返回
            return root;
        }
        TreeNode left = CommonAncestor(root.left,o1,o2); // 返回左侧的p\q节点
        TreeNode right = CommonAncestor(root.right,o1,o2); // 返回右侧的p\q节点

        if (left == null) {  // 都在右侧
            return right;
        }
        if (right == null) { // 都在左侧
            return left;
        }

        return root; // 在左右两侧
    }

}
