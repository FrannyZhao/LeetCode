package tree;

public class LC100SameTree {
    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        compareTreeNode(p, q);
        return isSame;
    }

    private void compareTreeNode(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                if (p.left == null && p.right == null && q.left == null && q.right == null) {
                    // same
                } else {
                    if (isSame) {
                        compareTreeNode(p.left, q.left);
                    }
                    if (isSame) {
                        compareTreeNode(p.right, q.right);
                    }
                }
            } else {
                isSame = false;
            }
        } else if (p != null) {
            isSame = false;
        } else if (q != null) {
            isSame = false;
        } else {
            // same
        }
    }


    public static void main(String[] args) {
        LC100SameTree test = new LC100SameTree();
        boolean result;
        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root1.left = node2;
        root1.right =  node3;
        TreeNode root2 = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3_1 = new TreeNode(3);
        root2.left = node2_1;
        root2.right =  node3_1;
        result = test.isSameTree(root1, root2);
        System.out.println(result);
        assert result;

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        result = test.isSameTree(root3, root4);
        System.out.println(result);
        assert !result;

        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(1);
        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(1);
        root6.right = new TreeNode(2);
        result = test.isSameTree(root5, root6);
        System.out.println(result);
        assert !result;


        System.out.println(" ====== Success! =====");
    }
}
