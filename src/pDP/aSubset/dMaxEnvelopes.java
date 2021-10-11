package pDP.aSubset;

/**
 * 354. 俄罗斯套娃信封问题
 * 最长递增子序列之信封嵌套问题
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 *
 * 示例 1：
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class dMaxEnvelopes {

    // https://mp.weixin.qq.com/s/PSDCjKlTh8MtANdgi-QIug

    /**
     * todo 先对宽度w进行升序排序，如果遇到w相同的情况，则按照高度h降序排序。之后把所有的h作为一个数组，在这个数组上计算 LIS 的长度就是答案。
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        return 0;
    }

}
