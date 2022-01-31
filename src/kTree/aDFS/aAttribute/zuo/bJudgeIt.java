package kTree.aDFS.aAttribute.zuo;

import lTree.TreeNode;

/**
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * todo 获取的info还必须包含val、leftVal、rightVal
 */
public class bJudgeIt {

    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if(root==null){
            return new boolean[]{false,false};
        }
        Info result = judgeItInfo(root);
        return new boolean[]{result.isSearch,result.isAll};
    }

    /**
     *
     * @param root
     * @return
     */
    public Info judgeItInfo(TreeNode root){

        if(root==null){ //todo 递归结束条件
            return new Info(true,true,null,null,null);
        }

        Info leftInfo=judgeItInfo(root.left); //todo 获取左子树信息
        Info rightInfo=judgeItInfo(root.right); //todo 获取右子树信息

        boolean isSearch=leftInfo.isSearch&&rightInfo.isSearch;
        boolean isAll=leftInfo.isAll&&rightInfo.isAll;

        //左节点为空 右节点不为空 则不是完全二叉树
        if(leftInfo.val == null && rightInfo.val != null){
            isAll=false;
        }
        // todo 判断是否为搜索树时注意 左右子树的左右子树也需要跟根节点比较
        if(leftInfo.val != null){
            isSearch = isSearch && leftInfo.val <= root.val;
            if(leftInfo.rightVal != null){
                isSearch = isSearch && leftInfo.rightVal <= root.val;
            }
        }

        if(rightInfo.val!=null){
            isSearch = isSearch && rightInfo.val >= root.val;
            if(rightInfo.leftVal != null){
                isSearch = isSearch && rightInfo.leftVal >= root.val;
            }
        }

        return new Info(isSearch,isAll,root.val,root.left==null?null:root.left.val,root.right==null?null:root.right.val);

    }

    class Info{  //todo 获取的info还必须包含val、leftVal、rightVal

        boolean isSearch;
        boolean isAll;
        Integer val;
        Integer leftVal;
        Integer rightVal;

        Info(boolean isSearch,boolean isAll,Integer val,Integer leftVal,Integer rightVal){
            this.isSearch=isSearch;
            this.isAll=isAll;
            this.val=val;
            this.leftVal=leftVal;
            this.rightVal=rightVal;
        }
    }

}
