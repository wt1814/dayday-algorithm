package aaSummary.fSlidingWindow.slidingWindow.twoArray;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 */
public class aZZZMinimumCoveringSubstringOfOther {

    public static void main(String[] args){
    	
        int[] arr = {2,2,3,4,8,99,3};
        String s = "XDOYEZODEYXNZ";
        String t = "XYZ";
        System.out.println(minWindow(s,t));

    }

    
    // todo labuladong https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=21#wechat_redirect
    // new https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247490774&idx=1&sn=cdada4b7ff9e1bfed0de8104541d9d11&chksm=fb418ff6cc3606e0b0d264a07f0730d04e9516b8eebb7421da81c93e8fd7f1b0582b739bc74e&scene=21#wechat_redirect
    // https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
    // https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac?tpId=188&&tqId=38617&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        // 初始化window和need两个哈希表，记录窗口中的字符和需要凑齐的字符
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0) + 1);
        }
        // 使用left和right变量初始化窗口的两端，不要忘了，区间[left, right)是左闭右开的，所以初始情况下窗口没有包含任何元素
        // todo 其中valid变量表示窗口中满足need条件的字符个数，如果valid和need.size的大小相同，则说明窗口已满足条件，已经完全覆盖了串T。
        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        /**
         * todo 现在开始套模板，只需要思考以下四个问题：
         * todo 1、当移动right扩大窗口，即加入字符时，应该更新哪些数据？
         * todo 2、什么条件下，窗口应该暂停扩大，开始移动left缩小窗口？
         * todo 3、当移动left缩小窗口，即移出字符时，应该更新哪些数据？
         * todo todo 4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
         */
        while(right < s.length()){
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);

                if(window.get(c).equals(need.get(c))){ // todo 进行比较
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(valid == need.size()){ // todo 找到了所有字符
                // 在这里更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    //这个得改成equals
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
        
    }


}
