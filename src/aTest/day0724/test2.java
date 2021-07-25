package aTest.day0724;


import gTree.TreeNode;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/25/21 12:17 AM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test2 {

    public static void main(String[] args){
        TreeNode treeNode0 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);

        //treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        boolean[] booleans = judgeIt(treeNode0);
        System.out.println(booleans[0]);
        System.out.println(booleans[1]);

    }

    public static boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] result = new boolean[2];
        if (root == null){
            result[0] = true;
            result[1] = true;
            return result;
        }

        Info it = it(root);
        result[0] = it.isSousuo;
        result[1] = it.isWanquan;
        return result;
    }

    public static Info it (TreeNode root) {

        if (root == null){
            return new Info(true,true);
        }
        Info rightInfo = it(root.right);
        Info leftInfo = it(root.left);
        boolean issou = true;
        boolean iswan = true;

        if (leftInfo.isSousuo == false || rightInfo.isSousuo == false){
            issou = false;
        }

        if ((root.left != null && root.left.val > root.val) || (root.right != null && root.right.val < root.val) ){
            issou = false;
        }

        if (leftInfo.isWanquan == false || rightInfo.isWanquan == false){
            iswan = false;
        }
        if (root.left == null && root.right != null){
            iswan = false;
        }

        return new Info(issou,iswan);

    }

    static class Info{
        public boolean isWanquan;
        public boolean isSousuo;

        public Info(boolean isSousuo,boolean isWanquan){
            this.isWanquan = isWanquan;
            this.isSousuo = isSousuo;
        }

    }


}
