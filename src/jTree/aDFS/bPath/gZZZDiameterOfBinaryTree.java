package jTree.aDFS.bPath;

import kTree.TreeNode;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * todo 这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class gZZZDiameterOfBinaryTree {


    public static void main(String[] args) {

    }


    ///////////////////////////////
    // https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
    static int ans; // todo 全局变量

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度

        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans

        int sum = Math.max(L, R) + 1; // todo 返回该节点为根的子树的深度

        return sum;
    }

}
