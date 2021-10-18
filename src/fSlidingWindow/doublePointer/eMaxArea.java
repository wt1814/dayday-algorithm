package fSlidingWindow.doublePointer;

/**
 * 11. 盛最多水的容器
 * leetcode： https://leetcode-cn.com/problems/container-with-most-water/
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 */
public class eMaxArea {


    public static void main(String[] args) {

        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(arr);
        System.out.println(i);

    }


    /**
     * 在初始时，左右指针分别指向数组的左右两端
     * 此时需要移动一个指针。移动哪一个呢？直觉告诉我们，
     * todo 应该移动对应数字较小的那个指针（即此时的左指针）。
     * 这是因为，由于容纳的水量是由两个指针指向的数字中较小值∗指针之间的距离
     */
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;  // 定义左右指针
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484229&idx=2&sn=e3d730a608987d3c764f17578ab4e8af&chksm=fd9ca85acaeb214cb2ab0e66b3ee5f8b20a5159aef56e23b92669669b039187836d53ce48bb7&scene=178&cur_album_id=1748659352518868992#rd



    ///////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487488&idx=1&sn=a31c5dc6f3351461621e72b281d5aa81&chksm=fb418320cc360a36d83158508dbf0edd2940e862b3a391a965a393cd4fc35c05c7c3ff7ab870&scene=21#wechat_redirect
    /**
     * 根据木桶原理，桶的容量是由最短的木板决定的，所以这里矩形的高度也是由最矮的柱子所决定的。
     * 我们可以使用两个指针，一个left指向左边的柱子，以他的高为矩形的高度，
     * 然后从最右边开始往左扫描，找到比left柱子高的为止（如果没找到，那么矩形的宽度就是0）。
     * 计算矩形面积之后，left再往右移一位，再以同样的方式继续查找……。
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxarea = 0, left = 0, length = height.length;
        int area;
        int right;
        //从前面开始找
        while (left < length) {
            right = length - 1;
            while (right > left) {
                if (height[right] < height[left]) {
                    right--;
                } else {
                    break;
                }
            }
            //计算矩形的面积
            area = height[left] * (right - left);
            //保存计算过的最大的面积
            maxarea = Math.max(maxarea, area);
            left++;
        }
        //从后面开始找，和上面类似
        right = length - 1;
        while (right > 0) {
            left = 0;
            while (right > left) {
                if (height[right] > height[left]) {
                    left++;
                } else {
                    break;
                }
            }
            area = height[right] * (right - left);
            maxarea = Math.max(maxarea, area);
            right--;
        }
        return maxarea;
    }


}
