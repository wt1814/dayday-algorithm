package fString.single;

/**
 * 考虑字符串开头有空格，单词间有多个空格空格的情况
 */
public class bStringReverse {

    public static void main(String[] args){
        String aa = " java and python ";
        System.out.println(swapWords(aa));
        String bb = " i'm wang tao ";
        System.out.println(swapWords(bb));
    }

    public static String swapWords(String s) {
        if (s == null) {
            return null;
        }
        String ret = "";
        if (!s.endsWith(" ")) {
            s += " ";
        }
        char[] charArr = s.toCharArray();
        int begin = 0;

        int i = 0;
        while (i < charArr.length) {
            while (charArr[i] == ' ' && i < charArr.length) {
                i++;
            }
            begin = i; // 获取单词的第一个字母对应的位置
            while (charArr[i] != ' ') { // 找到单词后第一个空格对应的位置
                i++;
            }
            swapStr(charArr, begin, i - 1);
            ++i;
        }
        ret = new String(charArr);
        return ret;
    }

    // 翻转一段字符串
    public static void swapStr(char[] arr, int begin, int end) {
        while (begin < end) {
            char tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
    }

}
