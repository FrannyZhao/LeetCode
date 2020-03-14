package tree;

public class LC104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        LC104MaximumDepthOfBinaryTree test = new LC104MaximumDepthOfBinaryTree();
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
        result = test.maxDepth(root);
        System.out.println(result);
        assert result == 3;


        System.out.println(" ====== Success! =====");
    }
}
