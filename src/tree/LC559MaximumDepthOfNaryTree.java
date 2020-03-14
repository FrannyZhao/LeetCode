package tree;

import java.util.List;

public class LC559MaximumDepthOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return countDepth(root);
    }

    private int countDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.children.size() != 0) {
            int depth = Integer.MIN_VALUE;
            for (Node child : node.children) {
                depth = Math.max(countDepth(child), depth);
            }
            return depth + 1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(" ====== Success! =====");
    }
}
