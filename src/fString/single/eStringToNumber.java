package fString.single;

/**
 * 字符串转整数
 */
public class eStringToNumber {

    //https://www.nowcoder.com/practice/44d8c152c38f43a1b10e168018dcc13f?tpId=188&&tqId=38578&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking

    /**
     *
     先去掉字符串两边的空格
     然后判断符号
     最后读取数字
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
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9){
                break;
            }
            //越界处理
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
