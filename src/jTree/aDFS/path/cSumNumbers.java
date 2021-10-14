package jTree.aDFS.path;

import jTree.TreeNode;

/**
 * DFS和BFS解求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 *
 * 示例 1:
 *
 *     输入: [1,2,3]
 *
 *         1
 *
 *        / \
 *
 *       2   3
 *
 *
 *     输出: 25
 *     解释:
 *     从根到叶子节点路径 1->2 代表数字 12.
 *     从根到叶子节点路径 1->3 代表数字 13.
 *     因此，数字总和 = 12 + 13 = 25.
 */
public class cSumNumbers {



    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247488603&idx=1&sn=2aa52a1bc63495431e59e3a89e8433a2&chksm=fb41877bcc360e6db4155574ac34526fade5e9a318f534ef5121b22a882c2122badd2cd99680&scene=21#wechat_redirect
    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        //终止条件的判断
        if (root == null){
            return 0;
        }
        //计算当前节点的值
        sum = sum * 10 + root.val;
        //如果当前节点是叶子节点，说明找到了一条完整路径，直接
        //返回这条路径的值即可
        if (root.left == null && root.right == null)
            return sum;
        //如果当前节点不是叶子结点，返回左右子节点的路径和
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

}
