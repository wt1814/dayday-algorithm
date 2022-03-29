package kTree.aDFS.bPath;

import kTree.TreeNode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 */
public class cHasPathSum {

    // https://mp.weixin.qq.com/s/7tKIHskFOGARb2Tuy43ezw
    public static boolean hasPathSum(TreeNode root, int sum) {

        //如果根节点为空，或者叶子节点也遍历完了也没找到这样的结果，就返回false
        if (root == null){
            return false;
        }
        //如果到叶子节点了，并且剩余值等于叶子节点的值，说明找到了这样的结果，直接返回true
        if (root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }
        //分别沿着左右子节点走下去，然后顺便把当前节点的值减掉，左右子节点只要有一个返回true，
        //说明存在这样的结果
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


    // https://leetcode-cn.com/problems/path-sum/
    // https://programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html



}
