package nDFSAndBacktrack.eMatrix;

/**
 * NC109 岛屿数量
 *  给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * 例如：
 * 输入
 * [
 * [1,1,0,0,0],
 * [0,1,0,1,1],
 * [0,0,0,1,1],
 * [0,0,0,0,0],
 * [0,0,1,1,1]
 * ]
 * 对应的输出为3
 *
 * 示例1
 * 输入：
 * [[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
 * 返回值：
 * 3
 */
public class cIslandsNum {


    /////////////////////////////todo DFS解决////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247488455&idx=1&sn=d10153be4fcb28e1ee07c495dabed205&chksm=fb4180e7cc3609f14614e605bef861fd4cdbeaa28ae46b7ffcb65f61a8ce421733d5b664b62a&scene=21#wechat_redirect
    /**
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {

        //统计岛屿的个数
        int count = 0;

        //边界条件判断
        if (grid == null || grid.length == 0){
            return 0;
        }

        //两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                //只有当前格子是1才开始计算
                if (grid[i][j] == '1') {
                    //如果当前格子是1，岛屿的数量加1
                    count++;
                    //然后通过dfs把当前格子的上下左右4
                    //个位置为1的都要置为0，因为他们是连着
                    //一起的算一个岛屿，
                    dfs(grid, i, j);
                }
            }
        }

        //最后返回岛屿的数量
        return count;

    }

    //这个方法会把当前格子以及他邻近的为1的格子都会置为1
    public static void dfs(char[][] grid, int i, int j) {

        //边界条件判断，不能越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        //把当前格子置为0，然后再从他的上下左右4个方向继续遍历
        grid[i][j] = '0';
        dfs(grid, i - 1, j);//上
        dfs(grid, i + 1, j);//下
        dfs(grid, i, j + 1);//左
        dfs(grid, i, j - 1);//右

    }



    /////////////////////////////todo BFS解决////////////////////////
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247488455&idx=1&sn=d10153be4fcb28e1ee07c495dabed205&chksm=fb4180e7cc3609f14614e605bef861fd4cdbeaa28ae46b7ffcb65f61a8ce421733d5b664b62a&scene=21#wechat_redirect



    ///////////////////////////////////////////////////////////////////////////
    // https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e?tpId=188&&tqId=38590&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking


}
