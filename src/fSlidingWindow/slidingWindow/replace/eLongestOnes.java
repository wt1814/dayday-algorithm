package fSlidingWindow.slidingWindow.replace;

/**
 * 521，滑动窗口解最大连续1的个数 III
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 * 给定一个由若干0和1组成的数组A， 我们最多可以将K个值从0变成1。
 * 返回仅包含1的最长（连续）子数组的长度。
 *
 * 示例 1：
 *     输入：A=[1,1,1,0,0,0,1,1,1,1,0],K=2
 *     输出：6
 *     解释：[1,1,1,0,0,1,1,1,1,1,1]
 *     粗体数字从0翻转到1，最长的子数组长度为6。
 */
public class eLongestOnes {

    public static void main(String[] args) {

    }

    ///////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486241&idx=1&sn=609ca05e6e21a72023172b52d0af0a75&chksm=fd9ca03ecaeb2928018ef5b2faf20b170ae123813eec30962d2ea2d3c93e78e54ddde0d51c87&scene=178&cur_album_id=1748659352518868992#rd

    public int longestOnes3(int[] nums, int k) {

        int ans = 0;
        int i = 0, j = 0;
        int tot = 0; // 动态维护一个左右区间 [j, i] 和维护窗口内和 tot

        for ( ;i < nums.length; i++) {
            tot += nums[i];
            while ((i - j + 1) - tot > k) { //右端点一直右移，左端点在窗口不满足「len - tol <= k」的时候进行右移。
                tot -= nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;

    }


    //////////////////////////////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247490276&idx=1&sn=ed83ac5d35bc85c37a1a70b99028d508&chksm=fb4189c4cc3600d21b52e850c52f65d490256da7bf340f1323279d447d5456b8630d2ab97497&scene=21#wechat_redirect
    /**
     * 可以使用两个指针，一个指向窗口的左边，一个指向窗口的右边，每次遍历数组的时候窗口左边的指针先不动，窗口右边的指针始终都会往右移动，
     * 然后顺便统计窗口内0的个数，如果0的个数大于K的时候，说明我们即使使用魔法，也不能把窗口内的所有数字都变为1，这个时候我们在移动窗口左边的指针，直到窗口内0的个数不大于K为止……
     * @param A
     * @param K
     * @return
     */
    public static int longestOnes(int[] A, int K) {
        int left = 0;//窗口左边的位置
        int maxWindow = 0;//窗口的最大值
        int zeroCount = 0;//窗口中0的个数
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                zeroCount++;
            }
            //如果窗口中0的个数超过了K，要缩小窗口的大小，直到0的个数
            //不大于K位置
            while (zeroCount > K) {
                if (A[left++] == 0){
                    zeroCount--;
                }
            }
            //记录最大的窗口
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }


    /**
     * 其实还可以换种思路，当窗口内0的个数刚好大于K的时候（也就是zeroCount+1==K），说明这个时候right指向的肯定是0，那么目前为止最大的窗口大小是(right-1)-left，因为窗口的右指针是一直往右滑动的，我们可以通过改变左指针的位置来缩小窗口。
     * 所以right-left(注意这里的left已经执行++了，在下面的第10行)始终指向的是最大窗口的值，最后我们只需要返回right-left即可，不需要while循环
     * @param A
     * @param K
     * @return
     */
    public static int longestOnesTwo(int[] A, int K) {
        int left = 0;//窗口左边的位置
        int right = 0;//窗口右边的位置
        int zeroCount = 0;//窗口中0的个数
        for (; right < A.length; right++) {
            if (A[right] == 0) {
                zeroCount++;
            }
            //如果窗口中0的个数超过了K，要缩小窗口的大小
            if(zeroCount > K && A[left++] == 0){
                zeroCount--;
            }
        }
        return right - left;
    }




}
