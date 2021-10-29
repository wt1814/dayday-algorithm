package jTree.bBFS;

import jTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 */
public class dWidthOfBinaryTree {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/_eRzaIcg8Tt0vEvkDcIJHA
    /**
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;
        //使用双端队列
        Deque<TreeNode> queue = new LinkedList<>();
        //把根节点加入到队列中
        queue.offer(root);
        //根节点的值我们把它修改为1
        root.val = 1;
        //记录最大的宽度
        int maxWide = 0;
        while (!queue.isEmpty()) {
            //当前层节点的数量
            int levelCount = queue.size();
            //todo todo todo todo todo 当前层最左边节点的值
            int left = queue.peekFirst().val;
            //todo todo todo todo todo 当前层最右边节点的值
            int right = queue.peekLast().val;
            //当前层的最大宽度就是right - left + 1，
            //这里计算之后要保留最大的
            maxWide = Math.max(maxWide, right - left + 1);
            //遍历当前层的所有节点，把他们的子节点在加入到队列中
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                int position = node.val;
                //如果左子节点不为空，就把左子节点加入到队列中
                if (node.left != null) {
                    node.left.val = position * 2;
                    queue.offer(node.left);
                }
                //如果右子节点不为空，就把右子节点加入到队列中
                if (node.right != null) {
                    node.right.val = position * 2 + 1;
                    queue.offer(node.right);
                }
            }
        }
        return maxWide;
    }

}
