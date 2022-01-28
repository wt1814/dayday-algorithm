package iHash;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
 */
public class bFirstNotRepeatingChar {

    public static void main(String[] args) {

    }

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
