package jTree.aDFS.aBasic;

import jTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 404. 左叶子之和
 */
public class sumOfLeftLeaves {



    // https://programmercarl.com/0404.%E5%B7%A6%E5%8F%B6%E5%AD%90%E4%B9%8B%E5%92%8C.html#%E9%80%92%E5%BD%92%E6%B3%95

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);    // 左
        int rightValue = sumOfLeftLeaves(root.right);  // 右

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) { // 中
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;
        return sum;
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<> ();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return result;
    }

    /**
     * 层序遍历迭代法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) { // 左节点不为空
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null){ // 左叶子节点
                        sum += node.left.val;
                    }
                }
                if (node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }

}
