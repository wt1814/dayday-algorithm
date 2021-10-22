package jTree.aDFS.aAttribute;

import jTree.TreeNode;

/**
 * 剑指 Offer-树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *          3
 *
 *         / \
 *
 *        4   5
 *
 *       / \
 *
 *      1   2
 *
 * 给定的树 B：
 *        4
 *
 *       /
 *
 *      1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *     输入：A = [1,2,3], B = [3,1]
 *     输出：false
 */
public class jIsSubStructure {

    // https://mp.weixin.qq.com/s/yNp0HuJjFWz8QviRcI6iCQ

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        //先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
        //只要有一个为true，就说明B是A的子结构
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSub(TreeNode A, TreeNode B) {
        //这里如果B为空，说明B已经访问完了，确定是A的子结构
        if (B == null){
            return true;
        }
        //如果B不为空A为空，或者这两个节点值不同，说明B树不是
        //A的子结构，直接返回false
        if (A == null || A.val != B.val){
            return false;
        }
        //当前节点比较完之后还要继续判断左右子节点
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }

}
