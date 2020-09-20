package tree;

public class LC687LongestUnivaluePath {
    int maxLength;
    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;
        if (root != null) {
            dfs(root);
        }
        return maxLength;
    }

    private int dfs(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node.left != null) {
            if (node.val == node.left.val) {
                left = dfs(node.left) + 1;
            } else {
                dfs(node.left);
            }
        }
        if (node.right != null) {
            if (node.val == node.right.val) {
                right = dfs(node.right) + 1;
            } else {
                dfs(node.right);
            }
        }
        maxLength = Math.max(maxLength, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        LC297SerializeAndDeserializeBinaryTree transfer = new LC297SerializeAndDeserializeBinaryTree();
        LC687LongestUnivaluePath test = new LC687LongestUnivaluePath();
        int result;

        result = test.longestUnivaluePath(transfer.deserialize("[5,4,5,1,1,null,5]"));
        System.out.println(result);
        assert result == 2;

        result = test.longestUnivaluePath(transfer.deserialize("[1,4,5,4,4,null,5]"));
        System.out.println(result);
        assert result == 2;

        result = test.longestUnivaluePath(transfer.deserialize("[1,2,3,2,2,3,3,2]"));
        System.out.println(result);
        assert result == 3;

        result = test.longestUnivaluePath(transfer.deserialize("[1,null,1,1,1,1,1,1]"));
        System.out.println(result);
        assert result == 4;

        System.out.println(" ====== Success! =====");
    }
}
