package jTree.dfs;

import jTree.TreeNode;

/**
 * 二叉树的最大路径和
 */
public class gMaxPathSum {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        System.out.println(maxPathSum(treeNode));

    }


    /**
     * https://blog.csdn.net/qq_28114615/article/details/86561069
     * 经过任一结点的路径和可能有哪些情况呢？
     * ①该结点本身；
     * ②过该结点左子结点的最大路径和加上该结点；
     * ③过该结点右子结点的最大路径和加上该结点；
     * ④过该结点左子结点的最大路径和以及过该结点右子结点的最大路径和再加上该结点。即是横跨该结点的左右子树。
     * 因此，假设该结点值为val，过左子结点的最大路径和为l，过右子结点的最大路径和为r，那么应该该结点的最大路径和就应当是max(val,l+val,r+val,l+r+val)，即四种情况中的最大值。
     * 那么，该怎么计算其中的l和r呢？计算l或者r，当然也是递归计算前面几种情况，即递归计算过左子结点的最大路径和以及过右子结点的最大路径和，但是这里有一点需要注意：计算过左子结点或右子结点的最大路径和时，需要排除第④种情况，因为第④种情况是横跨左右子树的，如果计算了第④种情况，那么当前结点是无法和它的左子结点或右子结点的最大路径和相连的。
     * 举个例子，将示例二中的根结点-10换成10，其右子结点为20，按照前面的说法，过根结点10的最大路径和的一种可能就是过其右子结点的最大路径和再加上根结点10，此时如果在计算过其右子结点的最大路径和的时候计算了第④种情况，那么最大路径和最终就必然是10+15+20+7，这显然是不正确的，因为这条路径横跨了根结点10的右子结点的左右子树，是无法达到根结点的。
     *  简单来说，如果将当前结点当做根结点，那么计算当前结点的最大路径和时就要考虑横跨当前结点左右子树的情况；
     *  如果将当前结点作为其父节点的子结点，那么计算过当前结点的最大路径和时就不能考虑横跨的情况。
     */
    int result = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        maxSum(root);
        return result;
    }

    private int maxSum(TreeNode root){  //求包含root根节点的最大路径和

        // todo 二叉树套路：1). 递归遍历 2). 返回的是递归需要的结果，非最终结果
        if(null == root){
            return 0;
        }
        int data = root.val;
        int maxL = maxSum(root.left);
        int maxR = maxSum(root.right);


        // todo 最终结果可以使用全局变量，此处流程便是求最终结果的流程。
        if(maxL > 0){
            data += maxL;
        }
        if(maxR > 0){
            data += maxR;
        }
        result = Math.max(result, data);    //记录当前树的最大路径和


        return Math.max(root.val, Math.max(root.val + maxL, root.val + maxR)); // todo 使用root.val，非之前定义的data
                                                                                // todo 原因待寻找xxx
    }


    //////////////////////////////

    /**
     * 求树的最大路径，递归树的节点
     * 有三种可能：
     *
     *     最大路径经过该节点本身从左子树到右子树
     *     最大路径经过节点本身向父节点发展
     *     最大路径就是节点本身
     *
     * 可以将左右边子树返回的满足情况2的最大路径和f(left)，f(right)，以及节点本身值val, 做一个组合，假设当前最大值是MAX： MAX = max(val, f(left)+val+f(right), f(left)+val, f(right)+val)
     * 因为要满足递归条件，向上级返回的f(n)只能是情况2或者3
     * f(n) = max(val, f(left)+val, f(right)+val)
     */

    static int MAX = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        calculate(root);
        return MAX;
    }

    public static int calculate(TreeNode node){

        // todo dfs的套路：节点为null，递归左子树，递归右子树。
        if(node == null) {
            return 0;
        }

        int left = 0;
        int right = 0;
        if(node.left!=null) {
            left = calculate(node.left);
        }
        if(node.right!=null) {
            right = calculate(node.right);
        }



        int sum = node.val;
        if(left>0) {
            sum += left;
        }
        if(right>0) {
            sum += right;
        }
        MAX = Math.max(MAX, sum);  // todo MAX记录的最大值
        // todo 记录左节点left、右节点right的最大值，再由MAX获取最终的最大值
        int maxTemp = Math.max(node.val, Math.max(left + node.val, right + node.val));
        return maxTemp;
    }

}
