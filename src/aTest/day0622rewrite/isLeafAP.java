package aTest.day0622rewrite;

import java.util.ArrayList;
import java.util.List;


public class isLeafAP {


    public static void main(String[] args){
        // 构造节点
        Node node4 = new isLeafAP().new Node(4);
        Node node6 = new isLeafAP().new Node(6);
        Node node7 = new isLeafAP().new Node(7);
        Node node1 = new isLeafAP().new Node(1);
        Node node9 = new isLeafAP().new Node(9);
        Node node3 = new isLeafAP().new Node(3);
        Node node5 = new isLeafAP().new Node(6);

        // 构造树
        node4.left = node6;
        node4.right = node7;
        node6.left = node1;
        node6.right = node9;
        node9.left = node3;
        node9.right = node5;

        System.out.println(isLeafAP(node4));
    }


    /**
     * 叶子节点是否等差
     * @param root
     * @return
     */
    public static boolean isLeafAP(Node root) {
        List<Integer> leafs = new ArrayList<>();
        // 获取叶子节点
        preOrderTraveral(leafs,root);
        // 是否等差
        boolean dengCha = isDengCha(leafs);
        return dengCha;
    }

    /**
     * 二叉树叶子节点
     * @param result
     * @param node
     */
    public static void preOrderTraveral(List<Integer> result, Node node){

        if(node == null){
            return;
        }

        if (node.left == null && node.right == null){
            result.add(node.val);
        }
        preOrderTraveral(result,node.left);
        preOrderTraveral(result,node.right);
    }


    /**
     * 是否等差队列
     * @param integers
     * @return
     */
    public static boolean isDengCha(List<Integer> integers){

        boolean result = true;

        if (integers.size() == 0 || integers.size() == 1){
            return result;
        }

        int chaJi = integers.get(1)-integers.get(0);
        for (int i = 0;i<integers.size()-1;i++){
            if (integers.get(i+1)-integers.get(i) != chaJi){
                result =false;
                break;
            }
        }

        return result;
    }


    //
    public class Node {

        public int val = 0;

        public Node left = null;
        public Node right = null;

        public Node(int x) {
            val = x;
        }
    }

}
