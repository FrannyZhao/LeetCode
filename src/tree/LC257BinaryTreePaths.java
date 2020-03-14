package tree;

import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePaths {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        deepDown(root, "");
        return result;
    }

    private void deepDown(TreeNode node, String pre) {
        if (node != null) {
            if (!pre.equals("")) {
                pre = pre + "->" + node.val;
            } else {
                pre = String.valueOf(node.val);
            }
            if (node.left == null && node.right == null) {
                result.add(pre);
            }

            if (node.left != null) {
                deepDown(node.left, pre);
            }
            if (node.right != null) {
                deepDown(node.right, pre);
            }
        }
    }

    public static void main(String[] args) {
        LC257BinaryTreePaths test = new LC257BinaryTreePaths();
        List<String> answer = new ArrayList<>();
        List<String> result;

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node5;
        answer.clear();
        answer.add("1->2->5");
        answer.add("1->3");
        result = test.binaryTreePaths(root);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
        assert answer.size() == result.size();
        for (int i = 0; i < answer.size(); i++) {
            assert answer.get(i).equals(result.get(i));
        }


        System.out.println(" ====== Success! =====");
    }
}
