package mTree.dfs;

import mTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树所有路径
 */
public class dAllPath {


    // https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
    // https://leetcode-cn.com/problems/binary-tree-paths/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-5f58/

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

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public static void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
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

}