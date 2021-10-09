package nDFSAndBacktrack.bCombine.str;

/**
 * todo 字符串的所有子序列(字符串的组合)
 * 题目：输入一个字符串，输出该字符串中字符的所有组合。
 * 例子：输入：abc，它的组合有：a、b、c、ab、ac、bc、abc
 */
public class gPrintAllSubsquenceOfother {

    //https://mp.weixin.qq.com/s?__biz=MzA5NDIwNTk2Mw==&mid=2247484636&amp;idx=1&amp;sn=9ea705d330e7955c83dcfc3d6a7f90d0&source=41#wechat_redirect
    // 左神 暴力递归到动态规划1
    // 理解：https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247483857&idx=1&sn=c4fbb9d55a656aac55c4976c48879c45&scene=21#wechat_redirect
    // https://leetcode-cn.com/problems/subsets/solution/liang-chong-fang-fa-qiu-jie-zi-ji-by-tangzixia/

    // 测试
    public static void main(String[] args) {

        printAllSubString("abc");
    }

    public static void printAllSubString(String str){
        if(str == null){
            return;
        }

        char[] chars = str.toCharArray();
        if(chars.length > 0){
            String pre = "";   // pre：用于表示从0到i-1位置上形成的结果
            printAllSubString( pre, chars,0);
        }else{
            System.out.println("");     // 输入空字符串也会打印空
        }
    }

    /**
     *
     * @param pre 结果集
     * @param chars 字符串字节数组
     * @param i 操作的下标
     */
    public static void printAllSubString(String pre, char[] chars,int i){
        // 迭代终止条件
        if(i == chars.length){   //todo 最后会执行一次i+1，所以是chars.length，而不是chars.length-1
            // 说明已经到最后一个字符了，所有的选择都已经做完了，应该返回了
            System.out.println(pre);  //todo 输出值可以用集合保存起来
            return;
        }

        // todo 如果没有到最后一个字符，那么当前字符有两种选择：选择要pre + String.valueOf(chars[i]) 和 选择不要pre
        printAllSubString(pre + String.valueOf(chars[i]), chars,i+1);   // 要当前字符
        printAllSubString(pre, chars,i+1);  // 不要当前字符
    }

}
