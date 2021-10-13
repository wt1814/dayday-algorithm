package fString.single;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 *     读入字符串并丢弃无用的前导空格
 *     检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 *     读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 *     将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 *     如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 *     返回整数作为最终结果。
 *
 * 注意：
 *     本题中的空白字符只包括空格字符 ' ' 。
 *     除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 *
 * 示例 4：
 * 输入：s = "words and 987"
 * 输出：0
 * 解释：
 * 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
 * 第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * 第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
 * 解析得到整数 0 ，因为没有读入任何数字。
 * 由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
 *
 * 示例 5：
 * 输入：s = "-91283472332"
 * 输出：-2147483648
 * 解释：
 * 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
 * 第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
 * 第 3 步："-91283472332"（读入 "91283472332"）
 * 解析得到整数 -91283472332 。
 * 由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
 *
 * 提示：
 *     0 <= s.length <= 200
 *     s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 */
public class eStringToNumber {

    public static void main(String[] args) {
        int i = atoi2("words and 987");
        System.out.println(i);
    }


    //https://www.nowcoder.com/practice/44d8c152c38f43a1b10e168018dcc13f?tpId=188&&tqId=38578&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    /**
     * 先去掉字符串两边的空格
     * 然后判断符号
     * 最后读取数字
     * @param str
     * @return
     */
    public static int atoi2 (String str) {

        str = str.trim();//去掉前后的空格
        //如果为空，直接返回0
        if (str.length() == 0){
            return 0;
        }

        int res = 0;//最终结果
        int index = 0;//遍历字符串中字符的位置
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = str.length();

        //判断符号
        if (str.charAt(index) == '-' || str.charAt(index) == '+'){
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }

        for (; index < length; ++index) {   // todo for循环里的计数，可以提前定义
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0'; //todo 转化为数字
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
            //todo 如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9){
                break;
            }
            //todo 越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            else{
                res = res * 10 + digit;
            }
        }
        return sign * res;

    }

    //////////////////////////////////////////////////////////////////////////////

    /**
     * 1.去除两端空白字符
     * 2.去掉空白字符后，截断非0~9数字
     * 3.判断首个字符是否为"+,-"符号
     * @param str
     * @return
     */
    public int atoi (String str) {

        byte[] bytes = str.trim().getBytes();
        int value = 0;//返回值

        //正负字符byte值
        byte p = '+';
        byte n = '-';

        //0-9数字区间byte值
        byte zero = '0';
        byte nine = '9';

        if(bytes.length == 0) {
            return value;
        }

        //过滤掉非无用字符，并只用endIndex作为截断位
        int endIndex = 1;
        for (int i = 1; i < bytes.length; i++) {

            //todo 判断是否为0~9数字
            if(bytes[i] < zero || bytes[i] > nine) {
                endIndex = i;
                break;
            }
            endIndex = i + 1;
        }

        //判断过滤后的值是否为空
        if(endIndex == 0) {
            return value;
        }

        for (int i = 0; i < endIndex; i++) {
            //如果第一个字符是正负符号，continue不做计算
            if(i == 0 && (bytes[i] == p || bytes[i] ==n)) {
                continue;
            }
            if(bytes[0] == n){//如果是正值-=
                value -= (bytes[i] % zero) * Math.pow(10, endIndex - 1 - i);
            }else{//否则+=
                value += (bytes[i] % zero) * Math.pow(10, endIndex - 1 - i);
            }
        }
        return value;
    }

}
