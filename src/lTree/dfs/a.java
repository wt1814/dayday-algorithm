package lTree.dfs;

import lTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right = treeNode1;

        System.out.println(hasPathSum(treeNode,3));
    }

    public static boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        return pathSumMethod(root,0,sum);

    }

    public static boolean pathSumMethod (TreeNode root,int pathSum, int sum) {
        // write code here

        if(root == null){
            return false;
        }

        int pathSumTemp = root.val+pathSum;

        if(root.left == null && root.right == null){
            return pathSumTemp == sum;
        }

        boolean result1 = pathSumMethod(root.left,pathSumTemp,sum);
        boolean result2 = pathSumMethod(root.right,pathSumTemp,sum);
        return result1 || result2;
    }
}
