package jTree.aDFS.bPath;

import jTree.TreeNode;

/**
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 */
public class ePathSum {

    public static void main(String[] args) {

    }

    // https://leetcode-cn.com/problems/path-sum-iii/solution/lu-jing-zong-he-iii-by-leetcode-solution-z9td/
    /**
     * 首先定义 rootSum(p,val)\textit{rootSum}(p,\textit{val})rootSum(p,val) 表示以节点 ppp 为起点向下且满足路径总和为 valvalval 的路径数目。我们对二叉树上每个节点 ppp 求出 rootSum(p,targetSum)\textit{rootSum}(p,\textit{targetSum})rootSum(p,targetSum)，然后对这些路径数目求和即为返回结果。
     * 对节点 ppp 求 rootSum(p,targetSum)\textit{rootSum}(p,\textit{targetSum})rootSum(p,targetSum) 时，以当前节点 ppp 为目标路径的起点递归向下进行搜索。假设当前的节点 ppp 的值为 val\textit{val}val，我们对左子树和右子树进行递归搜索，对节点 ppp 的左孩子节点 plp_{l}pl​ 求出 rootSum(pl,targetSum−val)\textit{rootSum}(p_{l},\textit{targetSum}-\textit{val})rootSum(pl​,targetSum−val)，以及对右孩子节点 prp_{r}pr​ 求出 rootSum(pr,targetSum−val)\textit{rootSum}(p_{r},\textit{targetSum}-\textit{val})rootSum(pr​,targetSum−val)。节点 ppp 的 rootSum(p,targetSum)\textit{rootSum}(p,\textit{targetSum})rootSum(p,targetSum) 即等于 rootSum(pl,targetSum−val)\textit{rootSum}(p_{l},\textit{targetSum}-\textit{val})rootSum(pl​,targetSum−val) 与 rootSum(pr,targetSum−val)\textit{rootSum}(p_{r},\textit{targetSum}-\textit{val})rootSum(pr​,targetSum−val) 之和，同时我们还需要判断一下当前节点 ppp 的值是否刚好等于 targetSum\textit{targetSum}targetSum。
     * 采用递归遍历二叉树的每个节点 ppp，对节点 ppp 求 rootSum(p,val)\textit{rootSum}(p,\textit{val})rootSum(p,val)，然后将每个节点所有求的值进行相加求和返回。
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public static int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}
