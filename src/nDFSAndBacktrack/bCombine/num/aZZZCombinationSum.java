package nDFSAndBacktrack.bCombine.num;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 第77题. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class aZZZCombinationSum {

    public static void main(String[] args) {

        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);

    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        combineHelper(n, k,result, path,1);
        return result;

    }

    /**
     *
     * @param n
     * @param k
     * @param result
     * @param path
     * @param startIndex
     */
    private static void combineHelper(int n, int k,List<List<Integer>> result, LinkedList<Integer> path,int startIndex){

        if (path.size() == k) {
            //todo 一般来说数组都是引用传递，当我们在一个分支修改了数组之后，其他分支上的数据也会改变，这也就造成了分支污染。所以在递归往下传递的时候我们都会新建一个数组，这样在当前分支的修改并不会影响到其他的分支，也就不会出错。
            result.add(new LinkedList<>(path));  // todo 一定初始化
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 处理节点
            combineHelper(n, k, result,path,i + 1); // 递归
            path.removeLast(); // 回溯，撤销处理的节点
        }

    }

    //////////////////////////////////////////////////////////todo 剪枝优化
    // https://programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E6%80%9D%E8%B7%AF
    // https://programmercarl.com/0077.%E7%BB%84%E5%90%88%E4%BC%98%E5%8C%96.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
    // https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247494135&idx=2&sn=3a17829d16a597246c20600a3a4bb2ce&scene=21#wechat_redirect
    // https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247485339&idx=1&sn=15eeae1e3e02c71519363c1fbc495ce7&chksm=fb4194bbcc361dad1df5e7762f21583b15fded5d4f6373615d5f82f0877fbaf511f650474c2a&scene=21#wechat_redirect


    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine1(int n, int k) {
        combineHelper1(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper1(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper1(n, k, i + 1);
            path.removeLast();
        }
    }


}
