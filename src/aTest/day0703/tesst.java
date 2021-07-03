package aTest.day0703;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: tesst
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/3/21 8:52 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class tesst {


    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(treeNode1);
        for (int i = 0;i<arrayLists.size();i++){
            ArrayList<Integer> integers = arrayLists.get(i);
            System.out.println("------------------");
            for (int j = 0;j<integers.size();j++){
                System.out.println(integers.get(j));
            }

        }

    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here

        ArrayList<ArrayList<Integer>> result = new ArrayList();

        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList();
        ArrayList<Integer> list = new ArrayList();

        queue.add(root);
        queue.add(null);
        list = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(null == node){
                if (queue.isEmpty()){
                    break;
                }
                queue.add(null);
                result.add(list);
                list = new ArrayList<>();
                continue;
            }
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        result.add(list);
        return result;
    }

}
