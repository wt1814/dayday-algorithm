package fSlidingWindow.SlidingWindow;

import java.util.HashMap;

/**
 * 542，滑动窗口解最小覆盖子串
 */
public class cMinimumCoveringSubstringOfOther {

    // new https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247490774&idx=1&sn=cdada4b7ff9e1bfed0de8104541d9d11&chksm=fb418ff6cc3606e0b0d264a07f0730d04e9516b8eebb7421da81c93e8fd7f1b0582b739bc74e&scene=21#wechat_redirect

    // https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
    // https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac?tpId=188&&tqId=38617&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking

    public static void main(String[] args){
        int[] arr = {2,2,3,4,8,99,3};
        String s = "XDOYEZODEYXNZ";
        String t = "XYZ";
        System.out.println(minWindow(s,t));

    }

    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);

                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while(valid == need.size()){ // todo 找到了所有字符
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    //这个得改成equals
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

}
