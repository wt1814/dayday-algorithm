package mTree.dfs;


import mTree.TreeNode;

/**
 * 是否是平衡二叉树
 */
public class gIsBalanced2 {

    public static boolean isBalenced(TreeNode root){
        if (root == null){
            return true;
        }
        
        if (isBalenced(root.left) && isBalenced(root.right) && Math.abs(height(root.left)-height(root.right))<=1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * todo 求二叉树高度
     * @param root
     * @return
     */
    private static int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

}
