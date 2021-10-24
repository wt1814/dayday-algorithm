package pDP.eTwoDimensional.bPath;

/**
 * 1575. 统计所有可行路径
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * 每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 * 请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 * 请你返回从 start 到 finish 所有可能路径的数目。
 * 由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 *
 * 示例 1：
 * 输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * 输出：4
 * 解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
 * 1 -> 3
 * 1 -> 2 -> 3
 * 1 -> 4 -> 3
 * 1 -> 4 -> 2 -> 3
 */
public class iCountRoutes {

    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485319&idx=1&sn=95a3dc9c97ca57185de792ca70924afe&chksm=fd9cac98caeb258ebea466f59378670a90af1cb3015ae70922e1d04ac711a5b8d8d853ac5e7d&scene=178&cur_album_id=1773144264147812354#rd
    // https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485297&idx=1&sn=5ee4ce31c42d368af0653f60aa263c82&chksm=fd9cac6ecaeb25787e6da90423c5467e1679da0a8aaf1a3445475199a8f148d8629e851fea57&scene=178&cur_album_id=1773144264147812354#rd
    // https://leetcode-cn.com/problems/count-all-possible-routes/

}
