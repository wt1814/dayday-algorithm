package jTree.aDFS.aAttribute;

import jTree.TreeNode;

/**
 * 513.找树左下角的值
 * todo 使用前序遍历
 * todo 前序遍历 和 层序遍历
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 */
public class kTraversalXXX {

    // https://programmercarl.com/0513.%E6%89%BE%E6%A0%91%E5%B7%A6%E4%B8%8B%E8%A7%92%E7%9A%84%E5%80%BC.html#%E9%80%92%E5%BD%92

    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) {
            findLeftValue(root.left,deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right,deep + 1);
        }

    }

    //////////////// 层序遍历
    // https://leetcode-cn.com/problems/find-bottom-left-tree-value/solution/ceng-xu-bian-li-by-ai-ru-shao-nian-m-bzrw/
    // https://leetcode-cn.com/problems/find-bottom-left-tree-value/solution/zi-jie-ti-ku-513-zhong-deng-zhao-shu-zuo-t56y/


}
