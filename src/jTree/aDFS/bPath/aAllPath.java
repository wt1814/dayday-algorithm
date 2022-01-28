package jTree.aDFS.bPath;

import java.util.ArrayList;
import java.util.List;

import kTree.TreeNode;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class aAllPath {

    public static void main(String[] args) {

        TreeNode TreeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode.left = treeNode1;
        TreeNode.right = treeNode2;

        List<String> stringList = binaryTreePaths(TreeNode);
        for (String s:stringList){
            System.out.println(s);
        }

    }

    // https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
    // https://leetcode-cn.com/problems/binary-tree-paths/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-5f58/
    // https://programmercarl.com/0257.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%89%80%E6%9C%89%E8%B7%AF%E5%BE%84.html#%E9%80%92%E5%BD%92

    /**
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    /**
     *
     * @param root
     * @param path
     * @param paths
     */
    public static void constructPaths(TreeNode root, String path, List<String> paths) {

        if (root == null){
            return;
        }

        StringBuffer pathSB = new StringBuffer(path);  // todo 使用到了回溯算法，因为是字符串...
        pathSB.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(pathSB.toString());  // 把路径加入到答案中
        } else {
            pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
            constructPaths(root.left, pathSB.toString(), paths);
            constructPaths(root.right, pathSB.toString(), paths);
        }

    }

}