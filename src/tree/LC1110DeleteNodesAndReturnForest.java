package tree;

import java.util.*;

public class LC1110DeleteNodesAndReturnForest {
    List<TreeNode> forest = new ArrayList<>();
    TreeSet<Integer> deletes = new TreeSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root != null) {
            for (int i : to_delete) {
                deletes.add(i);
            }
            dfs2(root.left, root, true);
            dfs2(root.right, root, false);
            if (!deletes.contains(root.val)) {
                forest.add(root);
            } else {
                if (root.left != null) {
                    forest.add(root.left);
                }
                if (root.right != null) {
                    forest.add(root.right);
                }
            }
        }
        return forest;
    }

    private void dfs2(TreeNode node, TreeNode parent, boolean isLeft) {
        if (node != null) {
            dfs2(node.left, node, true);
            dfs2(node.right, node, false);
            if (deletes.contains(node.val)) {
                if (node.left != null) {
                    forest.add(node.left);
                }
                if (node.right != null) {
                    forest.add(node.right);
                }
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        LC1110DeleteNodesAndReturnForest test = new LC1110DeleteNodesAndReturnForest();
        LC297SerializeAndDeserializeBinaryTree transfer = new LC297SerializeAndDeserializeBinaryTree();
        List<String> answer = new ArrayList<>();
        List<TreeNode> result = new ArrayList<>();
        List<String> resultTransfer = new ArrayList<>();

        answer.clear();
        result.clear();
        resultTransfer.clear();
        TreeNode root = transfer.deserialize("[1,2,3,4,5,6,7]");
        answer.add("[6]");
        answer.add("[7]");
        answer.add("[1,2,null,4]");
        result = test.delNodes(root, new int[]{3,5});
        for (TreeNode node : result) {
            resultTransfer.add(transfer.serialize(node));
        }
        for (String str : resultTransfer) {
            System.out.print(str + " ");
        }
        System.out.println();
        assert resultTransfer.size() == answer.size();
        for (int i = 0; i < answer.size(); i++) {
            assert answer.get(i).equals(resultTransfer.get(i));
        }

        answer.clear();
        result.clear();
        resultTransfer.clear();
        TreeNode root2 = transfer.deserialize("[1,2,null,4,3]");
        answer.add("[4]");
        answer.add("[1]");
        result = test.delNodes(root2, new int[]{2,3});
        for (TreeNode node : result) {
            resultTransfer.add(transfer.serialize(node));
        }
        for (String str : resultTransfer) {
            System.out.print(str + " ");
        }
        System.out.println();
        assert resultTransfer.size() == answer.size();
        for (int i = 0; i < answer.size(); i++) {
            assert answer.get(i).equals(resultTransfer.get(i));
        }

        answer.clear();
        result.clear();
        resultTransfer.clear();
        TreeNode root3 = transfer.deserialize("[1,2,3,null,null,null,4]");
        answer.add("[3,null,4]");
        result = test.delNodes(root3, new int[]{2,1});
        for (TreeNode node : result) {
            resultTransfer.add(transfer.serialize(node));
        }
        for (String str : resultTransfer) {
            System.out.print(str + " ");
        }
        System.out.println();
        assert resultTransfer.size() == answer.size();
        for (int i = 0; i < answer.size(); i++) {
            assert answer.get(i).equals(resultTransfer.get(i));
        }

        System.out.println(" ====== Success! =====");
    }
}
