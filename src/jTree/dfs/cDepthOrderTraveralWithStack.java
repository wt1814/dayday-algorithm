package jTree.dfs;

import jTree.TreeNode;

import java.util.Stack;

/**
 * todo 《左神课程》
 * 非递归 深度遍历
 * 先序 中左右
 * 中序 左中右
 * 后序 左右中
 *
 */
public class cDepthOrderTraveralWithStack {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode TreeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode.left = treeNode1;
        TreeNode.right = treeNode2;

        preOrderTraveralWithStack(TreeNode);
        inOrderTraveralWithStack(TreeNode);
        postOrderTraveralWithStack(TreeNode);
    }


    /**
     * 前序遍历
     * 弹就打印
     * 如有右，压入右
     * 如有左，压入左
     * @param root
     */
    public static void pre(TreeNode root){
        System.out.print("pre-order：");
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);  //todo 首先压入根节点

            while (!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.val + ""); //todo 弹就打印
                if (root.right != null){
                    stack.push(root.right); //todo 如有右，压入右
                }
                if (root.left != null){
                    stack.push(root.left); //todo 如有左，压入左
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     * 1). 整条左边界依次入栈
     * 2). 1)无法执行，弹出节点并打印；来到右树继续执行条件1)
     * 从栈的角度看，压入根节点、压入左节点 ---> 弹出左节点、弹出根节点 ---> 再处理右子树
     * @param root
     */
    public static void in(TreeNode root){
        System.out.print("in-order：");
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if (root != null){
                    stack.push(root);  // todo 1). 整条左边界依次入栈 （while条件、if条件、stack.push 3者是要把左子树全压到栈中）
                    root = root.left;
                }else {
                    root = stack.pop(); // todo  1)无法执行，弹出节点并打印
                    System.out.print(root.val + " ");
                    root = root.right;  // todo 来到右树继续执行条件1)
                }
            }
        }
        System.out.println();
    }

    /**
     * 后续遍历
     * todo 由先序到后序  中左右 ---> (过渡)中右左 ---> 左右中
     * todo 利用辅助栈，先序遍历设计中的栈弹出的元素压入辅助栈中。
     * @param root
     */
    public static void pos(TreeNode root){
        System.out.print("pos-order：");
        if (root != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>(); // 辅助栈
            s1.push(root);
            while (!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);  // todo s1栈弹出的元素压入辅助栈s2中
                if (root.left != null){
                    s1.push(root.left);
                }
                if (root.right != null){
                    s1.push(root.right);
                }
            }

            while (!s2.isEmpty()){
                System.out.print(s2.pop().val + " "); // todo 单独处理辅助栈中的数据
            }
        }
        System.out.println();
    }

    /**
     * 只用一个栈进行后序遍历
     * @param root
     */
    public static void pos2(TreeNode root){

    }

    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * 非递归 前序遍历
     * @param root
     */
    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode TreeNode = root;
        while(TreeNode !=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (TreeNode != null){
                System.out.println(TreeNode.val);
                stack.push(TreeNode);
                TreeNode = TreeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                TreeNode = stack.pop();
                TreeNode = TreeNode.right;
            }
        }
    }


    /**
     * 非递归 中序遍历
     * @param root
     */
    public static void inOrderTraveralWithStack(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode TreeNode = root;
        while(TreeNode != null || !stack.empty()) {
            while (TreeNode != null) {
                stack.push(TreeNode);
                TreeNode = TreeNode.left;
            }
            if(!stack.empty()) {
                TreeNode = stack.pop();
                System.out.println(TreeNode.val);
                TreeNode = TreeNode.right;
            }
        }
    }


    /**
     * 非递归 后序遍历
     * @param root
     */
    public static void postOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TreeNode TreeNode = root;
        int i = 1;
        while(TreeNode != null || !stack1.empty()) {
            while (TreeNode != null) {
                stack1.push(TreeNode);
                stack2.push(0);
                TreeNode = TreeNode.left;
            }

            while(!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.println(stack1.pop().val);
            }

            if(!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                TreeNode = stack1.peek();
                TreeNode = TreeNode.right;
            }
        }
    }



}
