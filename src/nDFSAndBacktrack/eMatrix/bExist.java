package nDFSAndBacktrack.eMatrix;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class bExist {


    public static void main(String[] args) {

    }

    //////////////////////////////////////////////////////
    // https://mp.weixin.qq.com/s/yZY1JlpCtiaMysN8LUHxKg
    // https://mp.weixin.qq.com/s/g6YKx_VoHOpVG6toLCpGtQ

    /**
     * 是从矩形中的一个点开始往他的上下左右四个方向查找，这个点可以是矩形中的任何一个点，所以代码的大致轮廓我们应该能写出来，就是遍历矩形所有的点，然后从这个点开始往他的4个方向走，
     * todo 因为是二维数组，所以有两个for循环
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 每一个点都可以往他的4个方向查找，所以我们可以把它想象为一棵4叉树，就是每个节点有4个子节点
     * @param board
     * @param word
     * @param i
     * @param j
     * @param index
     * @return
     */
    public static boolean dfs(char[][] board, char[] word, int i, int j, int index) {

        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]){
            return false;
        }
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1){
            return true;
        }
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;

    }


    //////////////////////////////////////////////////////
    // https://leetcode-cn.com/problems/word-search/solution/dan-ci-sou-suo-by-leetcode-solution/


}
