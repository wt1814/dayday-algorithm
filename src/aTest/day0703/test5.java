package aTest.day0703;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test5
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/4/21 10:34 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test5 {



    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        TreeNode mirror = Mirror(treeNode1);
        System.out.println("111"+mirror.val);

    }

    public static TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return null;
        }

        TreeNode root = new TreeNode(pRoot.val);
        mi(root,pRoot,2);

        return root;


    }


    public static void mi(TreeNode root,TreeNode pRoot,int isLeft){
        if(pRoot == null){
            return;
        }

        if(isLeft == 1){
            root = new TreeNode(pRoot.val);
        }else if(isLeft == 0){
            root = new TreeNode(pRoot.val);
        }

        mi(root.right,pRoot.left,1);
        mi(root.left,pRoot.right,0);

    }
}
