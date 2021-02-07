package leetcode.p222_count_complete_tree_nodes;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        return nodes(root);
    }

    private static int nodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + nodes(root.left) + nodes(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }
}
