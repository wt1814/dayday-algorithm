package nBFSAndDFSAndBacktrack.aRandk.num;


import java.util.HashSet;

/**
 * 去重全排列
 * 只需要增加一个 hashset，用于保证重复字符不会被再次交换。
 */
public class fPrintAllSortNoRepetition {


    public static void main(String[] args) {

        printAllSort("abcc");
    }


    public static void printAllSort(String string){
        if(string == null){
            return;
        }

        char[] chars = string.toCharArray();
        if(chars.length > 0){
            printAllSort(0, chars);
        }
    }

    /**
     * 对i及i以后的字符进行全排列
     * @param i
     * @param chars
     */
    public static void printAllSort(int i, char[] chars){
        // 递归终止条件
        if(i == chars.length){
            System.out.println(String.valueOf(chars));
        }

        // 用于保证每次交换的字符不存在重复的字符
        HashSet<Character> set = new HashSet<>();
        for(int j = i; j < chars.length; j++){
            if(!set.contains(chars[j])){
                set.add(chars[j]);
                // 第 i 个位置有 i ~ (n - 1) 种选择。n 为字符串的长度
                swap(i, j, chars);
                printAllSort(i + 1, chars);
                // 保证 i 后面的字符每次都是和 i 位置上的元素进行的交换，还需要将 i 和 j 交换回来
                swap(i, j, chars);
            }
        }
    }

    public static void swap(int i, int j, char[] chars){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
