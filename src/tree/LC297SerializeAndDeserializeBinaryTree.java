package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC297SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root != null) {
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            sb.append(root.val);
            treeNodeQueue.offer(root);
            while (!treeNodeQueue.isEmpty()) {
                TreeNode node = treeNodeQueue.poll();
                if (node.left != null) {
                    sb.append(",").append(node.left.val);
                    treeNodeQueue.offer(node.left);
                } else {
                    sb.append(",null");
                }
                if (node.right != null) {
                    sb.append(",").append(node.right.val);
                    treeNodeQueue.offer(node.right);
                } else {
                    sb.append(",null");
                }
            }
        }
        String result = sb.toString();
        while (result.endsWith(",null")) {
            result = result.substring(0, result.length() - 5);
        }
        return result + "]";
    }

    private TreeNode transfer(String str) {
        if ("null".equals(str)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(str));
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if ("".equals(data)) {
            return null;
        }
        String[] datas = data.split(",");
        TreeNode[] nodes = new TreeNode[datas.length];
        for (int i = 0; i < datas.length; i++) {
            String str = datas[i];
            if ("null".equals(str)) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(datas[i]));
            }
        }
        int i = 0, j = 0;
        TreeNode node;
        while (i < nodes.length) {
            node = nodes[j++];
            if (node != null) {
                if (++i < nodes.length) {
                    node.left = nodes[i];
                }
                if (++i < nodes.length) {
                    node.right = nodes[i];
                }
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        LC297SerializeAndDeserializeBinaryTree test = new LC297SerializeAndDeserializeBinaryTree();
        String decoder;
/*
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        decoder = test.serialize(root);
        System.out.println(decoder);
        assert "[1,2,3,null,null,4,5]".equals(decoder);

        TreeNode node = test.deserialize(decoder);
        assert node.val == root.val;
        assert node.left.val == root.left.val;
        assert node.right.val == root.right.val;
        assert node.right.left.val == root.right.left.val;
        assert node.right.right.val == root.right.right.val;
        decoder = test.serialize(node);
        System.out.println(decoder);
        assert "[1,2,3,null,null,4,5]".equals(decoder);
*/

        String result;
        result = test.serialize(test.deserialize("[]"));
        System.out.println(result);
        assert "[]".equals(result);

        result = test.serialize(test.deserialize("[1,2,3,null,null,4,5]"));
        System.out.println(result);
        assert "[1,2,3,null,null,4,5]".equals(result);

        result = test.serialize(test.deserialize("[5,2,3,null,null,2,4,3,1]"));
        System.out.println(result);
        assert "[5,2,3,null,null,2,4,3,1]".equals(result);

        result = test.serialize(test.deserialize("[1,2]"));
        System.out.println(result);
        assert "[1,2]".equals(result);

        System.out.println(" ====== Success! =====");
    }

}
