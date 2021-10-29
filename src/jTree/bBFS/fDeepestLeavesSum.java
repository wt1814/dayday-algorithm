package jTree.bBFS;

import jTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. BFS和DFS解层数最深叶子节点的和
 * 给你一棵二叉树的根节点root，请你返回层数最深的叶子节点的和。
 *
 * 示例 1:
 *     输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 *     输出：15
 */
public class fDeepestLeavesSum {

    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s/BOyoiVOrGWnemnBA357LFg
    //todo 可以把每一层所有节点的值都相加，下一层会把上一次的给覆盖掉，最后一层下面没有了，所以没法覆盖，直接返回即可。
    public static int deepestLeavesSum(TreeNode root) {
        //每层节点的和
        int res = 0;
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //队列不为空，继续访问队列的元素
        while (!queue.isEmpty()) {
            //当前层的节点数量
            int levelCount = queue.size();
            //当前层所有节点值的和
            res = 0;
            //遍历当前层的所有节点
            for (int j = 0; j < levelCount; j++) {
                TreeNode node = queue.poll();
                //累加当前层节点的值
                res += node.val;
                //如果左子节点不为空就把他加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                //如果右子节点不为空就把他加入到队列中
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }
    /**
     * 时间复杂度：O(N)，N是节点的个数，所有节点都要访问一遍
     * 空间复杂度：O(N)，队列中存放的是每层节点的个数，满二叉树的时候最后一层节点的个数是（N+1）/2
     */


}
