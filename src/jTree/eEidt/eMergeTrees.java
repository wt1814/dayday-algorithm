package jTree.eEidt;

import jTree.TreeNode;

/**
 * 617. 合并二叉树
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * todo 递归的深入理解
 */
public class eMergeTrees {



    // https://www.nowcoder.com/practice/7298353c24cc42e3bd5f0e0bd3d1d759?tpId=188&&tqId=38652&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }

        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }

        // 此时 t1、t2 均不为 null
        // 合并节点的值
        TreeNode merged = new TreeNode(t1.val + t2.val);

        // 合并左子树
        merged.left = mergeTrees(t1.left, t2.left);
        // 合并右子树
        merged.right = mergeTrees(t1.right, t2.right);

        return merged;

    }



    //////////////////////////////

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        // 此时 t1、t2 均不为 null
        // 合并节点的值
        t1.val = t1.val + t2.val;
        // 合并左子树
        t1.left = mergeTrees(t1.left, t2.left);
        // 合并右子树
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
