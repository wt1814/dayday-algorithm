package jTree.aDFS.aBasic;

import jTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * todo 《左神课程》基础班 课程7 《二叉树的基本算法》
 * 递归 深度遍历
 * 先序 中左右
 * 中序 左中右
 * 后序 左右中
 */
public class aDepthOrderTraversal {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        preOrderTraveral(treeNode);
        inOrderTraveral(treeNode);
        postOrderTraveral(treeNode);

    }

    /**
     * todo 基础：递归序
     * @param node
     */
    public static void orderTraveral(TreeNode node){

        if(node == null){
            return;
        }

        // 1. 前序
        orderTraveral(node.left);
        // 2. 中序
        orderTraveral(node.right);
        // 3. 后序
    }

    /**
     * 递归 前序遍历
     * @param node
     */
    public static void preOrderTraveral(TreeNode node){

        if(node == null){
            return;
        }
        System.out.println(node.val);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    /**
     * 递归 中序遍历
     * @param node
     */
    public static void inOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraveral(node.left);
        System.out.println(node.val);
        inOrderTraveral(node.right);
    }

    /**
     * 递归 后序遍历
     * @param node
     */
    public static void postOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.val);
    }

}
