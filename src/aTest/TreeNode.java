package aTest;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: TreeNode
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/22/21 4:20 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public static boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        String xString = String.valueOf(x);
        int xL = 0;
        for(int i = 0; i<=(xString.length()/2); i++){
            if (xString.charAt(0) != xString.charAt(xString.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}
