package aTest.day0911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: test2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 9/11/21 8:48 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class test2 {

    public static void main(String[] args){

        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            if(null == map.get(nums[i])){
                map.put(nums[i],1);
            }
        }

        List<Integer> result = new ArrayList();
        for(int j = 0;j<=nums.length;j++){
            if(map.get(j) == null){
                result.add(j);
            }
        }
        return result;

    }
}
