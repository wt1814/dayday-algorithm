package fSlidingWindow.SlidingWindow;

/**
 * 209. 长度最小的子数组
 */
public class dMinSubArrayLen {


    /**
     * 定义两个指针 start\textit{start}start 和 end\textit{end}end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，维护变量 sum\textit{sum}sum 存储子数组中的元素和（即从 nums[start]\text{nums}[\textit{start}]nums[start] 到 nums[end]\text{nums}[\textit{end}]nums[end] 的元素和）。
     * 初始状态下，start\textit{start}start 和 end\textit{end}end 都指向下标 000，sum\textit{sum}sum 的值为 000。
     * 每一轮迭代，将 nums[end]\text{nums}[end]nums[end] 加到 sum\textit{sum}sum，如果 sum≥s\textit{sum} \ge ssum≥s，则更新子数组的最小长度（此时子数组的长度是 end−start+1\textit{end}-\textit{start}+1end−start+1），然后将 nums[start]\text{nums}[start]nums[start] 从 sum\textit{sum}sum 中减去并将 start\textit{start}start 右移，直到 sum<s\textit{sum} < ssum<s，在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end\textit{end}end 右移。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
