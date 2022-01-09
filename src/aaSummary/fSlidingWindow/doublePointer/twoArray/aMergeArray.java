package aaSummary.fSlidingWindow.doublePointer.twoArray;

/**
 * 88. 合并两个有序数组，A数组长度足够长
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 */
public class aMergeArray {


    public static void main(String[] args) {

    }

    // https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=188&&tqId=38585&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    // https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/


    //////////////////////////////////////////////////////////////////////////////
    /**
     * todo 逆向双指针，两数组从后往前比
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    //////////////////////////////////////////////////////////////////////////////
    public static void merge3(int A[], int m, int B[], int n) {
        //因为题目明确说了A数组足够大，所以直接在A数组操作
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;   //AB合并后最后一个元素所在位置
        while(i >= 0 && j >= 0){   //AB合并，谁大就先放谁
            A[index --] = A[i] > B[j] ? A[i --] : B[j --];
        }
        while(j >= 0){   //如果B没有遍历完，那么之间丢在A数组里面
            A[index --] = B[j --];
        }

    }


    ////////////////////////////////////////////////////////////
    /**
     * 双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // 新建数组
        int[] sorted = new int[m + n];
        int cur;

        int p1 = 0, p2 = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

}
