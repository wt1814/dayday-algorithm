package kTree.bBFS;

import java.util.Deque;
import java.util.LinkedList;

import kTree.TreeNode;

/**
 * 662. 二叉树最大宽度
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 * 输入:
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 */
public class gZZZWidthOfBinaryTreeXXX {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/_eRzaIcg8Tt0vEvkDcIJHA
    /**
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null){
            return 0;
        }

        //记录最大的宽度
        int maxWide = 0;
        //使用双端队列
        Deque<TreeNode> queue = new LinkedList<>();
        //把根节点加入到队列中
        queue.offer(root);
        //根节点的值我们把它修改为1
        root.val = 1;

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
