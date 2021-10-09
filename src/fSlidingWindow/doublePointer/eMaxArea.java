package fSlidingWindow.doublePointer;

/**
 * 396，双指针求盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class eMaxArea {

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487488&idx=1&sn=a31c5dc6f3351461621e72b281d5aa81&chksm=fb418320cc360a36d83158508dbf0edd2940e862b3a391a965a393cd4fc35c05c7c3ff7ab870&scene=21#wechat_redirect
    /**
     * 根据木桶原理，桶的容量是由最短的木板决定的，所以这里矩形的高度也是由最矮的柱子所决定的。
     * 我们可以使用两个指针，一个left指向左边的柱子，以他的高为矩形的高度，
     * 然后从最右边开始往左扫描，找到比left柱子高的为止（如果没找到，那么矩形的宽度就是0）。
     * 计算矩形面积之后，left再往右移一位，再以同样的方式继续查找……。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
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