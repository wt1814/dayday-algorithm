package jTree.aDFS.aBasic;

import jTree.TreeNode;

public class fIsValidBST {

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
