package tree;

public class LC110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(countDepth(root.left) - countDepth(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int countDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(countDepth(node.left), countDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        LC110BalancedBinaryTree test = new LC110BalancedBinaryTree();
        boolean result;

        TreeNode root1 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;
        result = test.isBalanced(root1);
        System.out.println(result);
        assert result;

        TreeNode root2 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        root2.left = n1;
        root2.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        n3.right = n6;
        result = test.isBalanced(root2);
        System.out.println(result);
        assert !result;

        System.out.println(" ====== Success! =====");
    }
}
