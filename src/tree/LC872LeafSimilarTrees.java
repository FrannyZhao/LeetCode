package tree;

import java.util.ArrayList;
import java.util.List;

public class LC872LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        findLeaf(root1, leafs1);
        findLeaf(root2, leafs2);
//        for (int i : leafs1) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i : leafs2) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        boolean result = true;
        if (leafs1.size() == leafs2.size()) {
            for (int i = 0; i < leafs1.size(); i++) {
                if (leafs1.get(i) != leafs2.get(i)) {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    private void findLeaf(TreeNode node, List<Integer> leafs) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafs.add(node.val);
            }
            if (node.left != null) {
                findLeaf(node.left, leafs);
            }
            if (node.right != null) {
                findLeaf(node.right, leafs);
            }
        }
    }

    public static void main(String[] args) {
        LC872LeafSimilarTrees test = new LC872LeafSimilarTrees();
        LC297SerializeAndDeserializeBinaryTree transfer = new LC297SerializeAndDeserializeBinaryTree();
        boolean result;

        result = test.leafSimilar(transfer.deserialize("[3,5,1,6,2,9,8,null,null,7,4]"), transfer.deserialize("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]"));
        System.out.println(result);
        assert result;

        System.out.println(" ====== Success! =====");
    }
}
