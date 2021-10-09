package jTree.cBinarySearch;

import jTree.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
public class fIsValidBST {


    // https://programmercarl.com/0098.%E9%AA%8C%E8%AF%81%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html#%E8%BF%AD%E4%BB%A3%E6%B3%95
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {

        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        boolean left = isValidBST(node.left, lower, node.val);
        boolean right = isValidBST(node.right, node.val, upper);

        return left && right;
    }

}
