package jString.single;

/**
 * 回文子串的个数
 */
public class dPalindromeSubstring {


    public static void main(String[] args) {
        String str = "abcba";
        System.out.println("回文子字符串的个数为："+palindromeSubstring(str));
    }

    /**
     * 回文子串的个数
     * @param str
     * @return
     */
    public static int palindromeSubstring(String str) {
        int num=0;

        //子字符串的起始下标
        for(int i=0;i<str.length();i++){
            //子字符串的结束下标
            for(int j=i+2;j<=str.length();j++){
                //不要忘记j是<=str.lenth()，否则会丢失一个本身的回文字符串，因为substring(i,j)是截取i到j-1的字符串的
                String temp = str.substring(i,j);
                boolean b =isHuiWen(temp);
                if(b){
                    System.out.println(temp);
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * 判断是否回文串
     * @param str
     * @return
     */
    public static boolean isHuiWen(String str){
        //true:回文  false：非回文
        boolean flag = true;
        int len = str.length();
        for(int i=0;i<len/2;i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(len-1-i);
            if(c1!=c2){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
