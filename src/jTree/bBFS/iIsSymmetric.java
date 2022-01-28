package jTree.bBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kTree.TreeNode;

/**
 * 101. 对称二叉树
 */
public class iIsSymmetric {

    public static void main(String[] args) throws Exception {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        System.out.println(isSymmetric(treeNode1));

    }

    /**
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public static boolean isSymmetric (TreeNode root) {
        // write code here
        boolean result = true;

        if(root == null || (root.left == null && root.right == null)){
            return result;
        }

        List<List<Integer>> listTemp = new ArrayList();
        List<Integer> list = new ArrayList();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            /*if(null != cur){
                list.add(cur.val);
            }*/
            System.out.print(null == cur?" ":cur.val+" ");
            if(null == cur){
                // 判断list是否对称
                level++;
                result = isHuiwen(list,level);
                if(false == result){
                    break;
                }
                if(queue.isEmpty()){
                    break;
                }

                list = new ArrayList();
                queue.add(null);
                continue;
            }


            if (cur.left != null){
                queue.add(cur.left);
                list.add(cur.left.val);
            }else {
                list.add(-1);
            }
            if (cur.right != null){
                queue.add(cur.right);
                list.add(cur.right.val);
            }else {
                list.add(-1);
            }
        }

        return result;
    }

    public static boolean isHuiwen(List<Integer> list,int levle){
        boolean result = true;
        if(list == null){
            return result;
        }
        if (list.size() == 1 && levle ==1){
            return result;
        }else if (list.size() == 1 && levle !=1){
            return false;
        }

        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            if(list.get(left)!= list.get(right)){
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;

    }


    ////////////
    // 使用深度遍历 https://www.nowcoder.com/practice/1b0b7f371eae4204bc4a7570c84c2de1?tpId=188&&tqId=38623&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking


}
