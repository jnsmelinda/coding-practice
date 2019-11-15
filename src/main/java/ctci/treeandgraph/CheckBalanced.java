package ctci.treeandgraph;

public class CheckBalanced {

    public static boolean isBalanced(BinaryTree tree) {
        return getHeightDifference(tree.root) != Integer.MIN_VALUE;
    }

    private static int getHeightDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeightDifference(root.left);
        int rightHeight = getHeightDifference(root.right);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,8,6,9,2};
        BinaryTree tree = new BinaryTree(arr);
        tree.printSideways();
        System.out.println(isBalanced(tree));
    }
}
