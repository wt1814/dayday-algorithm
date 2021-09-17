package nBFSAndDFSAndBacktrack.dDivision;

import java.util.Arrays;

/**
 *
 */
public class canPartitionKSubsets {

    // 回溯算法解划分为k个相等的子集
    // https://mp.weixin.qq.com/s/F_uNCN-ldK1ReMjDwD8moQ

    // https://blog.csdn.net/qq_43539599/article/details/107631956
    // https://blog.csdn.net/qq_39445165/article/details/119476303

    // https://blog.csdn.net/weixin_42956047/article/details/106404967

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums,4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        //因为题目限制条件不用担心溢出
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //1.判断sum是否可以平均分成k份
        if(sum % k != 0){
            return false;
        }

        //求出子集的和
        sum = sum / k;
        //排序： 小的放最前面，大的放最后面
        Arrays.sort(nums);
        //2.如果子集的和小于数组最大的值，直接返回false
        if(nums[nums.length - 1] > sum) {
            return false;
        }

        //3.
        //建立一个长度为k的桶
        int[] arr = new int[k];
        //桶的每一个值都是子集的和
        Arrays.fill(arr, sum);
        //从数组最后一个数开始进行递归
        return dfs(nums, nums.length - 1, arr, k);
    }

    public static boolean dfs(int[] nums, int cur, int[] arr, int k) {
        //已经遍历到了-1, 说明前面的所有数都正好可以放入桶里，那所有桶的值此时都为0，说明找到了结果，返回true
        if(cur < 0) {
            return true;
        }

        //遍历k个桶
        for(int i = 0; i < k; i++) {
            //如果正好能放下当前的数 或者 放下当前的数后，还有机会继续放前面的数（剪枝）
            if(arr[i] == nums[cur] || (cur > 0 && arr[i] - nums[cur] >= nums[0])){
                //放当前的数到桶i里
                arr[i] -= nums[cur];
                //开始放下一个数
                if(dfs(nums, cur - 1, arr, k)) {
                    return true;
                }
                //这个数不该放在桶i中
                //从桶中拿回当前的数
                arr[i] += nums[cur];
            }
        }
        return false;
    }


    //////////////////////

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int total = 0;
        //统计所有火柴的长度
        for (int num : nums) {
            total += num;
        }
        //如果所有火柴的长度不是k的倍数，直接返回false
        if (total == 0 || total % k != 0)
            return false;
        //先排序
        Arrays.sort(nums);
        //回溯，从最长的火柴开始
        return backtrack(nums, nums.length - 1, total / k, new int[k]);
    }

    //index表示访问到当前火柴的位置，target表示正方形的边长，size是长度为k的数组，
    //分别保存正方形k个边的长度
    private boolean backtrack(int[] nums, int index, int target, int[] size) {
        if (index == -1) {
            //如果火柴都访问完了，并且size的k个边的长度都相等，说明是正k边形，直接返回true，
            //否则返回false
            // if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3])
            for (int i = 1; i < size.length; i++) {
                if (size[i] != size[i - 1]) {
                    return false;
                }
            }
            return true;
        }
        //到这一步说明火柴还没访问完
        for (int i = 0; i < size.length; i++) {
            //如果把当前火柴放到size[i]这个边上，他的长度大于target，我们直接跳过。或者
            // size[i] == size[i - 1]即上一个分支的值和当前分支的一样，上一个分支没有成功，
            //说明这个分支也不会成功，直接跳过即可。
            if (size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1]))
                continue;
            //如果当前火柴放到size[i]这个边上，长度不大于target，我们就放上面
            size[i] += nums[index];
            //然后在放下一个火柴，如果最终能变成正方形，直接返回true
            if (backtrack(nums, index - 1, target, size))
                return true;
            //如果当前火柴放到size[i]这个边上，最终不能构成正方形，我们就把他从
            //size[i]这个边上给移除，然后在试其他的边
            size[i] -= nums[index];
        }
        //如果不能构成正k边形，直接返回false
        return false;
    }

}
