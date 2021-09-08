package aTest.day0908;

import aTest.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class test {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        System.out.println(isValidBST(treeNode));


    }

    public static boolean isValidBST(TreeNode root) {

        return isValidBSTInfo(root).isValid;

    }


    public static Info isValidBSTInfo(TreeNode root){
        if(root == null){
            return new Info(null,true);
        }

        Info leftInfo = isValidBSTInfo(root.left);
        Info rightInfo = isValidBSTInfo(root.right);

        Info info = new Info(root.val,true);
        if(!leftInfo.isValid  || ! rightInfo.isValid){
            info.isValid = false;
        }

        if(( leftInfo.val != null && leftInfo.val >= root.val)  || (rightInfo.val != null &&  rightInfo.val <= root.val)){
            info.isValid = false;
        }

        return info;

    }



    public static class Info{
        public Integer val;
        public boolean isValid;

        public Info(){

        }

        public Info(Integer val,boolean isValid){

            this.val = val;
            this.isValid = isValid;

        }
    }

}
