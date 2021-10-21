package jTree.cBinarySearch.c;

import jTree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class bSortedArrayToBST {

    // https://programmercarl.com/0108.%E5%B0%86%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html
    // https://mp.weixin.qq.com/s/si3V7BBwgmtXsTNLD1T-Ow


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
        if(lNode != null) {
            node.left  = lNode;
        }
        if(rNode != null) {
            node.right = rNode;
        }
        return node;

    }

}

