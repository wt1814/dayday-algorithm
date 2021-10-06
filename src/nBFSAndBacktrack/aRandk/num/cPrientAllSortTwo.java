package nBFSAndBacktrack.aRandk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class cPrientAllSortTwo {

    public static void main(String[] args) {

    }

    // https://programmercarl.com/0047.%E5%85%A8%E6%8E%92%E5%88%97II.html#_47-%E5%85%A8%E6%8E%92%E5%88%97-ii
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247484527&idx=1&sn=c3459814e57949743b8b82a02e0078c1&chksm=fb41974fcc361e59990a3bea8224f3fd39787fe46cf85a39081681814a43d1ce7d5dc1bd553e&scene=21#wechat_redirect
    // https://mp.weixin.qq.com/s/sm9v4SIkVwXVjSfu5rtW_A
    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    /**
     *
     * @param list
     * @param tempList
     * @param nums
     */
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        // todo 输入数字有重复，下标从 0 开始
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {  // todo
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }

}
