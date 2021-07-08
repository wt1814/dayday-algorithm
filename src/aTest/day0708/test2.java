package aTest.day0708;

import mTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/8/21 6:22 PM
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

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;

        ArrayList<ArrayList<Integer>> arrayLists = zigzagLevelOrder(treeNode1);

        System.out.println("-------------"+arrayLists);

    }


    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }

        ArrayList<Integer> temp = null;
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
            if(poll != null && poll.val != 0){
                temp.add(poll.val);
            }
            if(level%2 ==1){
                if(poll.left != null){
                    queue.add(root.left);
                }
                if(poll.right != null){
                    queue.add(root.right);
                }
            }else{
                if(poll.right != null){
                    queue.add(root.right);
                }
                if(poll.left != null){
                    queue.add(root.left);
                }
            }

        }
        level++;

        if(level%2 ==0){
            result.add(temp);
        }else{
            for(int j = 0;j<temp.size()/2;j++){
                int temp4 = temp.get(j);
                temp.set(j,temp.get(temp.size()-j-1));
                temp.set(temp.size()-j-1,temp4);
            }
            result.add(temp);
        }

        return result;
    }



}