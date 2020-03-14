package tree;

public class LC111MinimumDepthOfBinaryTree {

    int result;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDepth(root);
    }

    private int countDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null && node.right == null) {
            return countDepth(node.left) + 1;
        }
        if (node.left == null && node.right != null) {
            return countDepth(node.right) + 1;
        }
        return Math.min(countDepth(node.left), countDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        LC111MinimumDepthOfBinaryTree test = new LC111MinimumDepthOfBinaryTree();
        int result;
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        result = test.minDepth(root);
        System.out.println(result);
        assert result == 2;


        System.out.println(" ====== Success! =====");
    }
}
