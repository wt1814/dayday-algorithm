package iString.single;

/**
 * 不考虑字符串开头有空格，单词间有多个空格空格的情况
 */
public class aStringReverse1 {


    public static void main(String[] args){
        String aa = "java and python ";
        System.out.println(swapWords(aa));
        String bb = "i'm wang tao ";
        System.out.println(swapWords(bb));
    }


    /**
     * 不考虑字符串开头有空格，单词间有多个空格空格的情况
     * @param s
     * @return
     */
    public static String swapWords(String s) {
        if (s == null) {
            return null;
        }
        String ret = "";

        // 字符串预先处理
        if (!s.endsWith(" ")) {
            s += " ";
        }

        // 字符串转换为字节数组
        char[] charArr = s.toCharArray();

        // 以空格为单位反转单个单词
        int begin = 0;
        //todo 从右往左遍历
        for (int i = charArr.length-1; i > 0; --i) {
            if (charArr[i] == ' ') {
                swapStr(charArr, begin, i - 1);
                begin = i + 1;
            }
        }

        // 拼接
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



    /////// 双指针反转字符串
    public static  String invertString(String var){
        byte[] bytes = var.getBytes();
        int left = 0;
        int right = bytes.length-1;

        while (left<right){
            byte temp = bytes[left];
            bytes[left] = bytes[right];
            bytes[right] = temp;
            left++;
            right--;
        }
        return new String(bytes);
    }
}
