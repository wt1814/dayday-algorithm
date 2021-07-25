package gTree.bfs;

import gTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历
 */
public class bLevelTraversalOfOneSelf {

    public static void main(String[] args){

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        ArrayList<ArrayList<Integer>> arrayLists = zigzagLevelOrder(treeNode1);
        for (int i = 0;i<arrayLists.size();i++){
            ArrayList<Integer> integers = arrayLists.get(i);
            System.out.println("------------------");
            for (int j = 0;j<integers.size();j++){
                System.out.println(integers.get(j));
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here

        ArrayList<ArrayList<Integer>> result = new ArrayList();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList(); //todo 放入到队列的是节点TreeNode类型
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
                continue;  //todo 跳出循环
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
