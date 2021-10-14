package jTree.aDFS.cBrother;

import jTree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class LowestCommonAncestor {


    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/V73MWneaud5A97j_Ltxnmw
    public static TreeNode lowestCommonAncestor(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null || cur == p || cur == q){
            return cur;
        }
        TreeNode left = lowestCommonAncestor(cur.left, p, q);
        TreeNode right = lowestCommonAncestor(cur.right, p, q);
        //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null){
            return right;
        }
        //同上
        if (right == null){
            return left;
        }
        //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
        //我们只需要返回cur结点即可。
        return cur;
    }


    /////////////////////////////////////////////////////////////////////////
    public static int lowestCommonAncestor1 (TreeNode root, int o1, int o2) {

        return CommonAncestor(root, o1, o2).val;
    }


    public static TreeNode CommonAncestor (TreeNode root, int o1, int o2) {

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




    /////////////////////////////////////////////////////////////////////////

    // https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
    // https://mp.weixin.qq.com/s/aWvfcCh4JjWxJVWpyr2WmQ


}
