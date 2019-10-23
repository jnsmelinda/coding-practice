package treeandgraph;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        root = buildTree(1, max);
    }

    private TreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new TreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
        }
    }

    public void printSideways() {
        if (root == null) {
            System.out.println("empty tree");
        } else {
            printSideways(root, 0);
        }
    }

    private void printSideways(TreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
}
