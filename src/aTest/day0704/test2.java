package aTest.day0704;

import aTest.day0703.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/4/21 9:22 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test2 {


    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
       /* treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;*/

        ArrayList<ArrayList<Integer>> arrayLists = zigzagLevelOrder(treeNode1);
        for (int i = 0;i<arrayLists.size();i++){
            ArrayList<Integer> integers = arrayLists.get(i);
            System.out.println("------------------");
            for (int j = 0;j<integers.size();j++){
                System.out.println(integers.get(j));
            }

        }

    }
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        if(root == null){
            return result;
        }
        ArrayList<Integer> temp = new ArrayList();

        path(root,result);
        return result;
    }

    public static void path(TreeNode root, ArrayList<ArrayList<Integer>> result ){

        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        int level = 1;
        temp = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(null == poll){
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                level++;
                result.add(temp);
                temp = new ArrayList();
                continue;
            }
            temp.add(poll.val);


            if(poll.left != null){
                queue.add(root.left);
            }
            if(poll.right != null){
                queue.add(root.right);
            }
        }

        result.add(temp);


    }

}
