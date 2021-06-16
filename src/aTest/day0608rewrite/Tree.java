package aTest.day0608rewrite;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: Tree
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/16/21 1:57 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
import java.util.ArrayList;
import java.util.List;

public class Tree {

    public Node run() {
        Node left, right;
        Node root = new Node(4);

        left = new Node(6);
        right = new Node(7);

        root.left = left;
        root.right = right;

        left.left = new Node(1);
        left.right = new Node(9);

        right = left.right;
        right.left = new Node(3);
        right.right = new Node(5);

        return root;

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.run();
        System.out.println(tree.isLeaf(root));
    }

    public void leaf(Node root, List<Integer> result) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                result.add(root.val);
            }
            if (root.left != null) {
                leaf(root.left, result);
            }

            if (root.right != null) {
                leaf(root.right, result);
            }
        }
    }

    public boolean isLeaf(Node root) {
        List<Integer> list = new ArrayList<>();
        leaf(root, list);

        list.forEach(System.out::println);

        int diff = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if ((list.get(i) - list.get(i - 1)) != diff) {
                return false;
            }
        }
        return true;
    }

    class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
