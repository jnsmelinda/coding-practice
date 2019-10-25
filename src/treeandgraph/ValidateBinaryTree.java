package treeandgraph;

public class ValidateBinaryTree {

    public static boolean validateBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private static boolean validateBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }
        if (!validateBST(root.left, min, root.data) || !validateBST(root.right, root.data, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 11, 6, 7, 2, 18};
        BinaryTree tree = new BinaryTree(arr);
        tree.printSideways();
        System.out.println(validateBST(tree.root));
    }
}
