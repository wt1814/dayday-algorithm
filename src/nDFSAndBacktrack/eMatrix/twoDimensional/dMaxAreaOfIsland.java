package nDFSAndBacktrack.eMatrix.twoDimensional;

/**
 * BFS和DFS两种方式求岛屿的最大面积
 * 给定一个包含了一些0和1的非空二维数组grid 。
 * 一个岛屿是由一些相邻的1(代表土地)构成的组合，这里的「相邻」要求两个1必须在水平或者竖直方向上相邻。你可以假设grid的四个边缘都被0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *     [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *      [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *      [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *      [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *      [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *      [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *      [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *      [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 */
public class dMaxAreaOfIsland {


    public static void main(String[] args) {

    }

    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487754&idx=1&sn=89e4896092bb4bf61b603626dcb4b0e7&chksm=fb41822acc360b3cac312a16a53334545d1fdfed3cc05a4cefa4f42fb5b23cc0b4e072160dff&scene=21#wechat_redirect
    /**
     * 这题无论使用DFS还是BFS都很好解决，DFS就是沿着一个方向一直走下去，直到不满足条件为止（要么走出grid的边缘，要么当前位置是0）。
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {//如果当前位置是1，开始计算
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public static int dfs(int[][] grid, int i, int j) {
        //边界条件的判断
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            //当前位置如果是1，为了防止重复计算就把他置为0，然后再从他的上下左右四个方向开始查找
            grid[i][j] = 0;
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        }
        return 0;
    }

}
