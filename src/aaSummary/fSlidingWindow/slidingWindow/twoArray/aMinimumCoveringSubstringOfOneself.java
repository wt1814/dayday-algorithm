package aaSummary.fSlidingWindow.slidingWindow.twoArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *     对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *     如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class aMinimumCoveringSubstringOfOneself {

    public static void main(String[] args){

        String s = "wyqaalfdtavrmkvrgbrmauenibfxrzjpzzqzlveexayjkvdsyueboloymtvfugvtgnutkyzhaztlvwdvqkwgvmejhbpdimwqbslnrkutkpehnkefwblrprcxvtaffzxitivmssgehklvwqastojihmhcfkhnlexemtrhnxlujxrgpuyiikspycufodubisfwnydaxrwhqqpfkppuzjlzlfhbjbcttkriixkiohpexgjjvafxjqyvyfyjhbccltlvsvdgeumdavoyxtvhmtekzctidxkqsxmlvrrzmefobtmznhizdmlcoemudwkvuyirscqegvsjrfkgoshrgsvvyhrbgdycehtwjlcrjucabpgsjnjqhhnfqeiwhgalptjyflpoiuqjjwdslpiswvxobfljnnwdhgdortezpulysoqddbxbwuqabdjqqhtzpxpjsvkjrvhjmzoralvzhlzkqkbgrwijvzspvcymafymfmfhaaghnfsdrvmlruuntmcqqbdqideprkxrmfbanvfeqrphnlwjxbzqcegmhnczxbslitnvotaemroadkjclksppzeyoiznlsytnopch" +
                "ritiyvlleqypiqgjugxeikpclipzxtgoebxcxkpdaoulecuajueretvpbkqbgwrkaooxbeaduvoaxlaifgblzwdcjtfpsxbsnrrovturokrovtycbcqcytfjomygj";
        String t = "baxtr";
        System.out.println(minWindow(s,t));

    }

    /**
     * 
     * @param S
     * @param T
     * @return
     */
    public static String minWindow(String S, String T) {

        int left = 0;
        int right = 0;
        int leftresult = 0;
        int rightresult = 0;

        HashMap<String,Integer> map = new HashMap<>();
        map.put("left",0);
        map.put("right",0);
        map.put("min",Integer.MAX_VALUE);

        while (right < S.length()){
            right++;                 // todo 右指针移动，直到满足条件
            if (comepare(S.substring(left,right), T)){
                rightresult = right;
            }
            while (comepare(S.substring(left,right), T)){
                leftresult = left;
                if (rightresult - leftresult +1 <map.get("min").intValue() ){
                    map.put("left",leftresult);
                    map.put("right",rightresult);
                    map.put("min",rightresult-leftresult+1);
                }
                left++;              // todo 左指针移动，直到不满足条件
            }
        }
        return S.substring(map.get("left"),map.get("right"));

    }


    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean comepare(String s, String t) {
        boolean result = true;
        char[] chars1 = t.toCharArray();
        HashMap<Character,Integer> need = new HashMap<>();
        for (int i =0;i<chars1.length;i++){
            Integer integer = need.get(chars1[i]);
            if (null == integer){
                need.put(chars1[i],1);
            }else {
                need.put(chars1[i],integer+1);
            }
        }

        HashMap<Character,Integer> window = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i =0;i<chars.length;i++){
            Integer integer = window.get(chars[i]);
            if (null == integer){
                window.put(chars[i],1);
            }else {
                window.put(chars[i],integer+1);
            }
        }

        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            Integer integer = window.get(entry.getKey());
            if(integer!= null && integer >= entry.getValue()){
                continue;
            }else {
                result = false;
                break;
            }

        }
        return result;
    }

}
