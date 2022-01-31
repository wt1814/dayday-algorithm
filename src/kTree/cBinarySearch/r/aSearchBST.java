package kTree.cBinarySearch.r;

import lTree.TreeNode;

/**
 *  700. 二叉搜索树中的搜索
 */
public class aSearchBST {

    public static void main(String[] args) {

    }

    // https://programmercarl.com/0700.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E6%90%9C%E7%B4%A2.html#java
    // 递归，普通二叉树
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST(root.right, val);
    }

    // 递归，利用二叉搜索树特点，优化
    public static TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
