package binary_search;

public class LC222CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
/*
    // Return tree depth in O(d) time.
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodes(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;
        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;
        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int)Math.pow(2, d) - 1 + left;
    }
*/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        TreeNode node = root;
        while (node.left != null) {
            depth++;
            node = node.left;
        }
        int upperCount = (int) Math.pow(2, depth) - 1;
        int left = 0;
        int right = (int) Math.pow(2, depth) - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (exist(root, depth, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int bottomCount = 0;
        if (exist(root, depth, right)) {
            bottomCount = right + 1;
        }
        if (exist(root, depth, left)) {
            bottomCount = Math.max(bottomCount, left + 1);
        }
        return upperCount + bottomCount;
    }

    private boolean exist(TreeNode node, int depth, int index) {
        int d = 0;
        int left = 0;
        int right = (int)Math.pow(2, depth) - 1;
        while (d < depth) {
            int pivot = left + (right - left) / 2 + 1;
            if (index < pivot) { // go left
                right = pivot - 1;
                node = node.left;
            } else { // go right
                left = pivot;
                node = node.right;
            }
            d++;
        }
        return node != null;
    }


    public static void main(String[] args) {
        LC222CountCompleteTreeNodes test = new LC222CountCompleteTreeNodes();
        int result;
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        result = test.countNodes(root);
        System.out.println(result);
        assert result == 6;

        TreeNode root2 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        root2.left = n1;
        root2.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n3.left = n7;
        n3.right = n8;
        n4.left = n9;
        n4.right = n10;
        n5.left = n11;
        result = test.countNodes(root2);
        System.out.println(result);
        assert result == 12;

        System.out.println(" ====== Success! =====");
    }
}
