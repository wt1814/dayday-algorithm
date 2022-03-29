package kTree.aDFS.aAttribute.zuo;

import kTree.TreeNode;

/**
 * 110. 平衡二叉树
 * todo 左神 课程8 《二叉树的递归套路》
 */
public class aIsBalanced {

    public static void main(String[] args) {

    }

    ////////////////////////////////////////////////////////////////////
    public static boolean isBalanced2(TreeNode head) {

        return process(head).isBalanced;
    }

    /**
     * todo 二叉树的递归dfs套路
     * 1) 假设以x节点为头，假设可以向x左树和x右树要任何信息
     * 2) 在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要）
     * 3) 列出所有可能性后，确定到底需要向左树和右树要什么样的信息
     * 4) 把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S
     * 5) 递归函数都返回S，每一颗子树都这么要求
     * 6) 写代码，在代码中考虑如何把左树都信息和右树信息整合出整棵树的信息
     */
    public static Info process(TreeNode x) {

        if(x == null) {   // todo 递归终止条件
            return new Info(true, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height)  + 1;
        boolean isBalanced = true;
        if(!leftInfo.isBalanced) {
            isBalanced = false;
        }
        if(!rightInfo.isBalanced) {
            isBalanced = false;
        }
        if(Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);

    }

    /**
     *
     */
    public static class Info{

        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }

    }


    //////////////////////////////////////////////////////////////////////////////////////////
    // https://programmercarl.com/0110.%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91.html#java



}
