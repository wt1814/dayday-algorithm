package jTree.aDFS;

import jTree.TreeNode;

/**
 * 将升序数组转化为平衡二叉搜索树
 */
public class SortedArrayToBST {

    public static void main(String[] args){
        int[] num = {-1,0,1,2};
        TreeNode treeNode = sortedArrayToBST(num);
        System.out.println(treeNode.val);
    }

    /**
     * 将升序数组转化为平衡二叉搜索树
     * @param num
     * @return
     */
    public static TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if(num == null){
            return null;
        }
        return helper(num, 0, num.length - 1);
    }

    private static TreeNode helper(int[] num, int left, int right) {
        if(left > right){
            return null;
        }

        int mid = left + (right - left + 1) / 2; //todo 理论上left + (right-left) / 2和left + (right - left + 1) / 2都是合法的
        TreeNode root = new TreeNode(num[mid]);
        TreeNode lNode = helper(num,left,mid-1);
        TreeNode rNode = helper(num,mid+1,right);
        root.left = lNode;
        root.right = rNode;
        return root;

    }


    /////////////////////////////////////////////////////////

    private static TreeNode helper1(int[] num, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left + 1) / 2; //todo 理论上left + (right-left) / 2和left + (right - left + 1) / 2都是合法的
        TreeNode lNode = helper1(num, left, mid - 1);
        TreeNode rNode = helper1(num, mid + 1, right);
        TreeNode node = new TreeNode(num[mid]);
        if(lNode != null) node.left  = lNode;
        if(rNode != null) node.right = rNode;
        return node;
    }

}
