package tree;

public class LC543DiameterOfBinaryTree {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        countDepth(root);
        return result;
    }

    private int countDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = countDepth(node.left);
        int rightDepth = countDepth(node.right);
        result = Math.max(result, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        LC543DiameterOfBinaryTree test = new LC543DiameterOfBinaryTree();
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
        result = test.diameterOfBinaryTree(root);
        System.out.println(result);
        assert result == 3;




        System.out.println(" ====== Success! =====");
    }
}
