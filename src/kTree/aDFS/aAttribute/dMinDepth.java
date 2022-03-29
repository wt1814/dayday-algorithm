package kTree.aDFS.aAttribute;

import kTree.TreeNode;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class dMinDepth {

    public static void main(String[] args) {

    }

    //////////////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/WJj7rNR8I2gT3mKllP--VQ
    public static int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        //左子树的最小深度
        int left = minDepth(root.left);
        //右子树的最小深度
        int right = minDepth(root.right);
        //如果left和right都为0，我们返回1即可，
        //如果left和right只有一个为0，说明他只有一个子结点，只需要返回它另一个子节点的最小深度+1即可。
        //如果left和right都不为0，说明他有两个子节点，我们只需要返回最小深度的+1即可。
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }



    //////////////////////////////////////////////////////////////////////////////////
    /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
     */
    public static int minDepth2(TreeNode root) {

        if (root == null){
            return 0;
        }
        //如果左子树等于空，我们返回右子树的最小高度+1
        if (root.left == null){
            return minDepth2(root.right) + 1;
        }
        //如果右子树等于空，我们返回左子树的最小高度+1
        if (root.right == null){
            return minDepth2(root.left) + 1;
        }
        //如果左右子树都不为空，我们返回左右子树深度最小的那个+1
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;

    }



    /////////////////////////////////////////////////////////////////////////
    // https://programmercarl.com/0111.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E6%B7%B1%E5%BA%A6.html


}
