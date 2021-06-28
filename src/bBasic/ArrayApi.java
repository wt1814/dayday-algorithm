package bBasic;

import java.util.Arrays;

/**
 * 数组基础操作
 */
public class ArrayApi {


    /**
     * 删除指定位置的元素
     * @param index
     * @param array
     * @return
     */
    public int[] delete2(int index, int array[]) {
        //todo 数组的删除其实就是覆盖前一位
        int[] arrNew = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (i < index) {
                arrNew[i] = array[i];
            } else {
                arrNew[i] = array[i + 1];
            }
        }
        return arrNew;
    }

}
