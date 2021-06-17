package jRecursion.string;

/**
 * 字符串的所有子序列(字符串的组合)
 * 题目：输入一个字符串，输出该字符串中字符的所有组合。
 * 例子：输入：abc，它的组合有：a、b、c、ab、ac、bc、abc
 */
public class ePrintAllSubsquence {

    //https://mp.weixin.qq.com/s?__biz=MzA5NDIwNTk2Mw==&mid=2247484636&amp;idx=1&amp;sn=9ea705d330e7955c83dcfc3d6a7f90d0&source=41#wechat_redirect
    // 左神 暴力递归到动态规划1
    // 理解：https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247483857&idx=1&sn=c4fbb9d55a656aac55c4976c48879c45&scene=21#wechat_redirect


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
            printAllSubString(0, pre, chars);
        }else{
            System.out.println("");     // 输入空字符串也会打印空
        }
    }

    /**
     *
     * @param i
     * @param pre
     * @param chars
     */
    public static void printAllSubString(int i, String pre, char[] chars){
        // 迭代终止条件
        if(i == chars.length){
            // 说明已经到最后一个字符了，所有的选择都已经做完了，应该返回了
            System.out.println(pre);  //todo 输出值可以用集合保存起来
            return;
        }

        // 如果没有到最后一个字符，那么当前字符有两种选择：选择要 和 选择不要
        printAllSubString(i + 1, pre, chars);  // 不要当前字符
        printAllSubString(i + 1, pre + String.valueOf(chars[i]), chars);   // 要当前字符
    }

    //////////////////////////////////////


}
