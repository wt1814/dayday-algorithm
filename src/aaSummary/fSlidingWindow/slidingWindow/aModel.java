package aaSummary.fSlidingWindow.slidingWindow;


/**
 * 滑动窗口模板
 * todo ★★★求满足一定条件的 “连续子串” 一般用滑动窗口
 * todo 当窗口不满足要求的时候，向右拓宽边界
 * todo 当窗口满足的时候，向左收缩边界
 */
public class aModel {

    // https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac?tpId=188&&tqId=38617&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking

    public void window(String S, String T) {

/*        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> target = new HashMap<>();

        for (int i = 0;i<t.length;i++){
            target.put(t[i],i);
        }
        int left = 0, right = 0;    // 初始化双指针
        //...                       // 定义状态值

        while (right < s.length){
            // 增大窗口
            char c = s[right];
            ++right;
            //...                   // 更新window
            while (达到缩小窗口的条件){
                //...               // 更新状态值
                char cc = s[left];
                ++left;
                //...               // 更新window/状态值

            }
        }*/


    }

}
