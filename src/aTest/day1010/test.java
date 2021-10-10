package aTest.day1010;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        test test = new test();
        List<List<Integer>> lists = test.combinationSum3(3, 7);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();        // 用于存储全部结果
    LinkedList<Integer> track = new LinkedList<>();     // 用于存储单次的返回结果

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, n, k, 1);
        return res;
    }

    // 递归函数
    public void backtrack(int curSum, int targetSum, int k, int start) {
        // base case
        if (track.size() == k) {
            if (curSum == targetSum) {
                res.add(new ArrayList<>(track));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            // 做选择
            track.add(i);
            curSum += i;
            // 递归遍历
            backtrack(curSum, targetSum, k, i + 1);
            // 回溯，撤销选择
            curSum -= i;
            track.removeLast();
        }
    }


}
