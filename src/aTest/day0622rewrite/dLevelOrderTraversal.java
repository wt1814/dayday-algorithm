package aTest.day0622rewrite;

import mTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: dLevelOrderTraversal
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/22/21 4:21 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class dLevelOrderTraversal {


    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        level(treeNode1);
    }

    public static void level(TreeNode root) {
        if (root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null){
                queue.add(root.left);
            }
            if (poll.right != null){
                queue.add(root.right);
            }

        }

    }

}
