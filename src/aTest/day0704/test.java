package aTest.day0704;

import aTest.day0703.TreeNode;

import java.util.ArrayList;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 7/4/21 8:58 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test {

    public int sumNumbers (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        int result = 0;
        ArrayList<ArrayList<Integer>> allnums = new ArrayList();
        ArrayList<Integer> nums = new ArrayList();
        allPath(root,allnums,nums);
        for(int i = 0;i<allnums.size();i++){
            ArrayList<Integer> temp = allnums.get(i);
            for(int j = temp.size()-1;j>=0;j--){
                result = result + temp.get(j) * (int)Math.pow(10,(temp.size()-j-1));
            }

        }
        return  result;

    }

    public void allPath(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums){
        if(root == null){
            return;
        }

        nums.add(root.val);

        if(root.left == null && root.right == null){
            ArrayList<Integer> temp = new ArrayList();
            for(int i=0;i<nums.size();i++){
                temp.add(nums.get(i));
            }
            result.add(temp);
        }

        allPath(root.left,result,nums);
        allPath(root.right,result,nums);
        nums.remove(nums.size()-1);

    }

}