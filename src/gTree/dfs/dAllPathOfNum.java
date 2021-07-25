package gTree.dfs;

import gTree.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树所有路径
 * todo 回溯
 */
public class dAllPathOfNum {

    public static void main(String[] args) {


        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;


/*        1 2 4 6
        1 2 4 7
        1 3 5*/

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> nums = new ArrayList<>();
        preOrder(result,nums,treeNode);

        for (int i = 0;i<result.size();i++){
            ArrayList<Integer> integers = result.get(i);
            System.out.println("------------------");
            for (int j = 0;j<integers.size();j++){
                System.out.println(integers.get(j));
            }
        }

    }

    /**
     *
     * @param result
     * @param nums
     * @param root
     */
    public static void preOrder(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums, TreeNode root){

        if(root == null){
            return;
        }

        nums.add(root.val); // todo 先添加节点，再判断该节点是否叶节点

        if(root.left == null && root.right == null){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0;i<nums.size();i++){
                temp.add(nums.get(i));
            }
            result.add(temp);
        }

        preOrder(result,nums,root.left);
        preOrder(result,nums,root.right);
        nums.remove(nums.size()-1);   //todo todo todo 回溯

    }

}
