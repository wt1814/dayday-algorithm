package aTest.day0703;

import java.util.ArrayList;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/3/21 9:59 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {



    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(-1);
        TreeNode treeNode2 = new TreeNode(-2);
/*        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);*/
        treeNode1.right = treeNode2;
/*        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;*/

        ArrayList<ArrayList<Integer>> arrayLists = pathSum(treeNode1, -3);
        for (int i = 0;i<arrayLists.size();i++){
            ArrayList<Integer> integers = arrayLists.get(i);
            System.out.println("------------------");
            for (int j = 0;j<integers.size();j++){
                System.out.println(integers.get(j));
            }

        }

    }

    @SuppressWarnings("unchecked")
    public static ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        if(root == null){
            return result;
        }

        ArrayList<Integer> nums = new ArrayList();
        preOrder(result,nums,root);

        for(int i = 0;i<result.size();i++){
            ArrayList<Integer> temp = result.get(i);
            int num = 0;
            for(int j = 0;j<=temp.size();j++){
                if(j == temp.size()){
                    if(num != sum){
                        result.remove(i);
                        i--;
                    }
                    break;
                }
                num = num+temp.get(j);
            }
        }

        System.out.println("---------");
        return result;
    }

    public static void preOrder(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> nums,TreeNode root){

        if(root == null){
            return;
        }

        nums.add(root.val);

        if(root.left == null && root.right == null){
            result.add(nums);
            nums = new ArrayList();
        }

        if(root.left != null){
            preOrder(result,nums,root.left);
        }
        if(root.right != null){
            preOrder(result,nums,root.right);
        }
    }
}
