package nDFSAndBacktrack.eMatrix;

/**
 * 剑指 Offer-使用DFS和BFS解机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *     输入：m = 2, n = 3, k = 1
 *     输出：3
 */
public class aMovingCount {



    public static void main(String[] args) {

    }


    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487853&idx=2&sn=c1251de81a7c127eced39aecb14a140f&chksm=fb41824dcc360b5b6ba9ea9a30c2abbc4b8e22161366d8847c4689c6cab8894071d735198aa4&scene=21#wechat_redirect
    /**
     *
     * @param m
     * @param n
     * @param k 不能进入行坐标和列坐标的数位之和大于k的格子
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     * 这里统计的是能走多少个格子，所以统计肯定是不能有重复的，题中说了，机器人是可以沿着上下左右四个方向走的。但你想一下，任何一个格子你从任何一个方向进来（比如从上面进来），那么他只能往其他3个方向走，因为如果在往回走就重复了。
     * todo 但实际上我们只要沿着两个方向走就可以了，一个是右边，一个是下边。
     * @param i
     * @param j
     * @param m
     * @param n
     * @param k
     * @param visited
     * @return
     */
    public static int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {

        //i >= m || j >= n是边界条件的判断，k < sum(i, j)判断当前格子坐标是否
        // 满足条件，visited[i][j]判断这个格子是否被访问过
        if (i >= m || j >= n || k < sum(i, j) || visited[i][j]){
            return 0;
        }
        //标注这个格子被访问过
        visited[i][j] = true;
        //沿着当前格子的右边和下边继续访问
        int left = dfs(i + 1, j, m, n, k, visited);
        int down = dfs(i, j + 1, m, n, k, visited);

        return 1 + left + down;

    }

    //计算两个坐标数字的和
    private static int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }




}
