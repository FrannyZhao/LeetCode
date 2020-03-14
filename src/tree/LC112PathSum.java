package tree;

public class LC112PathSum {
    boolean hasFound = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        countSum(root, 0, sum);
        return hasFound;
    }

    private void countSum(TreeNode node, int preSum, int sum) {
        if (node != null) {
            int curSum = preSum + node.val;
            if (node.left == null && node.right == null) {
                hasFound = sum == curSum;
            }
            if (node.left != null && !hasFound) {
                countSum(node.left, curSum, sum);
            }
            if (node.right != null && !hasFound) {
                countSum(node.right, curSum, sum);
            }
        }
    }


    public static void main(String[] args) {
        LC112PathSum test = new LC112PathSum();
        boolean result;
        TreeNode root = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4_2 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        root.left = n4;
        root.right = n8;
        n4.left = n11;
        n8.left = n13;
        n8.right = n4_2;
        n11.left = n7;
        n11.right = n2;
        n4_2.right = n1;
        result = test.hasPathSum(root, 22);
        System.out.println(result);
        assert result;

        System.out.println(" ====== Success! =====");
    }
}
