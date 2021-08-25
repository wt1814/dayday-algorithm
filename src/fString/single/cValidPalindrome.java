package fString.single;

/**
 * 验证回文串
 */
public class cValidPalindrome {

    public static void main(String[] args){

        System.out.println(isHuiWen("abbba"));
    }

    /**
     * 方式一：双指针
     * @param str
     * @return
     */
    public static boolean isHuiWen(String str){

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


    // 方式二
    // 反转字符串。如果是回文串，则它的反转字符串等于它本身

}
