package dSort;

/**
 * 归并排序 --- 迭代求解
 */
public class eMergeSortOfItera {



    // https://www.cnblogs.com/sheeva/p/6600666.html
    //todo 迭代解题
    private static int count = 0;

    public static int[] sort(int[] data) {

        return sort(data, 0, data.length - 1);
    }

    private static int[] sort(int[] data, int low, int high) {
        if (low == high) {
            return new int[] { data[low] };
        }
        int mid = (low + high) >> 1;
        int[] left = sort(data, low, mid); //(1)
        int[] right = sort(data, mid + 1, high); //(2)

        int[] result = new int[high - low + 1];
        int i = 0, k = 0;
        //(3)
        for (int j = 0; j < result.length; j++) {
            count++;
            if (i == left.length) {
                result[j] = right[k++];
            } else if (k == right.length) {
                result[j] = left[i++];
            } else {
                if (left[i] <= right[k]) {
                    result[j] = left[i++];
                } else {
                    result[j] = right[k++];
                }
            }
        }
        return result;
    }


}
