package iString;

/**
 * 双指针反转字符串
 */
public class InvertString {


    public static void main(String[] args){
        System.out.println(invertString("abcde"));
    }

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
