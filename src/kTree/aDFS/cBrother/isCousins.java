package kTree.aDFS.cBrother;

import kTree.TreeNode;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 */
public class isCousins {


    public static void main(String[] args) {

    }

    // https://leetcode-cn.com/problems/cousins-in-binary-tree/solution/er-cha-shu-de-tang-xiong-di-jie-dian-by-mfh2d/
    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    /**
     * todo 只需要在深度优先搜索的递归函数中增加表示「深度」以及「父节点」的两个参数即可。
     * @param node
     * @param depth
     * @param parent
     */
    public void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }

        // 如果两个节点都找到了，就可以提前退出遍历
        // 即使不提前退出，对最坏情况下的时间复杂度也不会有影响
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);

        if (xFound && yFound) {
            return;
        }

        dfs(node.right, depth + 1, node);
    }

    ///////////////////////

    //https://mp.weixin.qq.com/s/Xpo_vYbihrtUahCyXR-LAA

    public boolean isCousins1(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        //如果他俩的深度一样，也就是在同一层，又不是同一个父亲，那么他俩
        //就是堂兄弟节点，否则不是
        return xDepth == yDepth && xParent != yParent ? true : false;
    }

    public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null){
            return;
        }
        if (root.val == x) {
            //如果找到了x节点，就把他的父节点和深度记录下来
            xParent = parent;
            xDepth = depth;
        } else if (root.val == y) {
            //如果找到了y节点，就把他的父节点和深度记录下来
            yParent = parent;
            yDepth = depth;
        }
        //如果确定他俩是堂兄弟节点了，直接返回，不用再往下遍历了
        if (xDepth == yDepth && xParent != yParent){
            return;
        }
        dfs(root.left, root, x, y, depth + 1);
        dfs(root.right, root, x, y, depth + 1);
    }


}
