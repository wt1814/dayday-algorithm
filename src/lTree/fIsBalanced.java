package lTree;

/**
 * 是否平衡树
 * todo 左神 课程8 《二叉树的递归套路》
 */

/**
 * todo 二叉树的递归dfs套路
 * 1) 假设以x节点为头，假设可以向x左树和x右树要任何信息
 * 2) 在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要）
 * 3) 列出所有可能性后，确定到底需要向左树和右树要什么样的信息
 * 4) 把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S
 * 5) 递归函数都返回S，每一颗子树都这么要求
 * 6) 写代码，在代码中考虑如何把左树都信息和右树信息整合出整棵树的信息
 */
public class fIsBalanced {

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    ////////////////////////////////////////////////////////////////////
    public static boolean isBalanced2(Node head) {
        return process(head).isBalanced;
    }

    public static Info process(Node x) {
        if(x == null) {
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

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    ////////////////////////////////////////////////////////////////////

    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }




    /////////////////////////////////////////////////////////////////////
    // 构造二叉树
    public static Node generateRandomBST(int maxLevel, int maxValue) {

        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }


    /////////////////////////////////////////////////////////////////////
    // 节点
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


}
