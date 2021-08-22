package iHash;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 */
public class bFirstNotRepeatingChar {

    // 遍历一遍字符串，统计每个字符出现的次数。
    // todo 然后再遍历一遍字符串，找出答案。
    //  非遍历map
    public static int FirstNotRepeatingChar(String str) {

        int result = -1;

        if(str == null || str.length() ==0){
            return -1;
        }

        HashMap<Character,Integer> map = new HashMap();
        char[] strs = str.toCharArray();

        for(int i = 0;i<strs.length;i++){
            int num = map.get(strs[i]) == null?0:map.get(strs[i]) ;
            if(num == 0){
                map.put(strs[i],1);
            }else{
                map.put(strs[i],num+1);
            }
        }

        for(int i = 0;i<strs.length;i++){
            if(map.get(strs[i]) == 1){
                result = i;
                break;
            }
        }
        return result;
    }


}
