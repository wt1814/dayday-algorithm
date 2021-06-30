
import mTree.TreeNode;

import java.util.*;

/**
 * @ProjectName：java-algorithm
 * @ClassName: Test
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 2020-05-19 10:04
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class Test {


    public static void main(String[] args) throws Exception {



        System.out.println(FirstNotRepeatingChar("google"));


    }

    public static int FirstNotRepeatingChar(String str) {

        int result = -1;

        if(str == null || str.length() ==0){
            return -1;
        }

        HashMap<Character,Integer> map = new HashMap();
        char[] strs = str.toCharArray();

        for(int i = 0;i<strs.length;i++){
            System.out.println("11 "+map.get(strs[i]));
            int num = map.get(strs[i]) == null?0:map.get(strs[i]);
            if(num == 0){
                map.put(strs[i],1);
            }else{
                map.put(strs[i],num+1);
            }
        }

        for(int i = 0;i<strs.length;i++){
            if(map.get(strs[i]) == 1){
                result = i;
            }
        }

        return result;
    }

    /**
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public static boolean isSymmetric (TreeNode root) {
        // write code here
        boolean result = true;

        if(root == null || (root.left == null && root.right == null)){
            return result;
        }

        List<List<Integer>> listTemp = new ArrayList();
        List<Integer> list = new ArrayList();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            /*if(null != cur){
                list.add(cur.val);
            }*/
            System.out.print(null == cur?" ":cur.val+" ");
            if(null == cur){
                // 判断list是否对称
                level++;
                result = isHuiwen(list,level);
                if(false == result){
                    break;
                }
                if(queue.isEmpty()){
                    break;
                }

                list = new ArrayList();
                queue.add(null);
                continue;
            }


            if (cur.left != null){
                queue.add(cur.left);
                list.add(cur.left.val);
            }else {
                list.add(-1);
            }
            if (cur.right != null){
                queue.add(cur.right);
                list.add(cur.right.val);
            }else {
                list.add(-1);
            }
        }

        return result;
    }

    public static boolean isHuiwen(List<Integer> list,int levle){
        boolean result = true;
        if(list == null){
            return result;
        }
        if (list.size() == 1 && levle ==1){
            return result;
        }else if (list.size() == 1 && levle !=1){
            return false;
        }

        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            if(list.get(left)!= list.get(right)){
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;

    }

    /**
     *
     * @param x int整型
     * @return int整型
     */
    public static int sqrt (int x) {
        // write code here

        if(x == 0 || x ==1){
            return x;
        }

        //查找范围起点
        int start=0;
        //查找范围终点
        int end=x;
        //查找范围中位数
        int mid;

        while(start<end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(mid == x /mid || ((mid < x /mid) && ((mid+1) >x /(mid+1)))) {  //todo 防止int超范围，用除法
                return mid;
            }else if(mid < x / mid){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;

    }

}
