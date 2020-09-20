package tree;

public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        LC297SerializeAndDeserializeBinaryTree transfer = new LC297SerializeAndDeserializeBinaryTree();
        LC226InvertBinaryTree test = new LC226InvertBinaryTree();
        String result;

        result = transfer.serialize(test.invertTree(transfer.deserialize("[4,2,7,1,3,6,9]")));
        System.out.println(result);
        assert "[4,7,2,9,6,3,1]".equals(result);


        System.out.println(" ====== Success! =====");
    }
}
