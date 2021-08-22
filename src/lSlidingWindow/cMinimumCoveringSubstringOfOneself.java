package lSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class cMinimumCoveringSubstringOfOneself {

    public static void main(String[] args){

        String s = "wyqaalfdtavrmkvrgbrmauenibfxrzjpzzqzlveexayjkvdsyueboloymtvfugvtgnutkyzhaztlvwdvqkwgvmejhbpdimwqbslnrkutkpehnkefwblrprcxvtaffzxitivmssgehklvwqastojihmhcfkhnlexemtrhnxlujxrgpuyiikspycufodubisfwnydaxrwhqqpfkppuzjlzlfhbjbcttkriixkiohpexgjjvafxjqyvyfyjhbccltlvsvdgeumdavoyxtvhmtekzctidxkqsxmlvrrzmefobtmznhizdmlcoemudwkvuyirscqegvsjrfkgoshrgsvvyhrbgdycehtwjlcrjucabpgsjnjqhhnfqeiwhgalptjyflpoiuqjjwdslpiswvxobfljnnwdhgdortezpulysoqddbxbwuqabdjqqhtzpxpjsvkjrvhjmzoralvzhlzkqkbgrwijvzspvcymafymfmfhaaghnfsdrvmlruuntmcqqbdqideprkxrmfbanvfeqrphnlwjxbzqcegmhnczxbslitnvotaemroadkjclksppzeyoiznlsytnopch" +
                "ritiyvlleqypiqgjugxeikpclipzxtgoebxcxkpdaoulecuajueretvpbkqbgwrkaooxbeaduvoaxlaifgblzwdcjtfpsxbsnrrovturokrovtycbcqcytfjomygj";
        String t = "baxtr";

        System.out.println(minWindow(s,t));

    }

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
