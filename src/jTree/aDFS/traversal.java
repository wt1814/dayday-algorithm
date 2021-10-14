package jTree.aDFS;

import jTree.TreeNode;

/**
 * 513.找树左下角的值
 */
public class traversal {

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

}
