package lTree.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * todo 《左神课程》基础班 课程7 《二叉树的基本算法》
 * 树的最大深度
 * todo 层序遍历解题递归套路
 * 层序遍历，key在哪一层
 * todo 可以通过设置flag变量的方式，来发现某一层的结束。
 */
public class fTreeMaxWidth {

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    /**
     * 使用map统计，新层到来，统计旧层
     * 每个节点进队列时设置层数
     * 弹出节点时，取出当前节点层数
     * 如果弹出节点层是当前层，则统计节点加1
     * 如果弹出节点层不是当前层，新的一层开始
     * @param head
     * @return
     */
    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //todo key 在 哪一层，value
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1; //todo 当前你正在统计哪一层的宽度
        int curLevelNodes = 0; //todo 当前层curLevel层，宽度目前是多少
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur); //当前节点的层数
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1); //左孩子的层数
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }


            if (curNodeLevel == curLevel) { // 当前节点的层数就是当前统计的层数
                curLevelNodes++;
            } else {                        //todo 上一层结束
                max = Math.max(max, curLevelNodes);
                curLevel++;                 //当前层加1
                curLevelNodes = 1;          //此时弹出的节点是新一层的节点
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    /**
     * 不使用map统计
     * @param head
     * @return
     */
    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head; // 当前层，最右节点是谁
        Node nextEnd = null; // 下一层，最右节点是谁
        int max = 0;
        int curLevelNodes = 0; // 当前层的节点数
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;  //todo 实时更新最右节点
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right; //todo 实时更新最右节点
            }
            curLevelNodes++;
            if (cur == curEnd) { // todo 当前节点是当前层最后一个节点
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0; // 下一层节点
                curEnd = nextEnd; //todo 设置下一层的最右节点，也就是即将开始的当前层
            }
        }
        return max;
    }

    ////////////////////////////////////////////////////
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

}
