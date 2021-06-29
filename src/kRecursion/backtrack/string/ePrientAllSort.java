package kRecursion.backtrack.string;

import java.util.ArrayList;

/**
 * 字符串全排列
 * todo 回溯
 * 找到所有所有可能的组合，如有必要再去重
 */
public class ePrientAllSort {


    public static void main(String[] args) {
        System.out.println(Permutation("ab"));
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        findPermutation(res, chars, 0);
        return res;
    }

    /**
     * 对chars[i~length-1]范围内的字符数组完成全排列,并将结果存入res中
     * todo 注：这里操作的是字符串字节数组，非原始字符串
     * @param res
     * @param chars
     * @param i
     */
    private static void findPermutation(ArrayList<String> res, char[] chars, int i) {

        // todo 递归终止条件
        if (i == chars.length) {
            res.add(new String(chars));
            return;
        }
        //从[i~length-1]枚举确定i位置的字符
        for (int j = i; j < chars.length; j++) {
            //交换
            swap(chars, i, j);
            //确定好i的位置,对[i+1~length-1]范围内的字符数组完成全排列
            findPermutation(res, chars, i + 1);
            //恢复原数组
            swap(chars, i, j);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

