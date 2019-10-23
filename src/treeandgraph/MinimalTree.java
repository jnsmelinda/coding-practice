package treeandgraph;

public class MinimalTree {

    private static TreeNode root;

    public MinimalTree() {
        root = null;
    }

    public static void makeMinimal(int[] arr) {
        for (int element : arr) {
            root = add(root, element);
        }
    }

    private static TreeNode add(TreeNode root, int element) {
            if (root == null) {
                root = new TreeNode(element);
            } else if (root.left == null || root.right == null) {
                root.left = add(root.left, element);
                root.right = add(root.right, element);
            }

        return root;
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        MinimalTree tree = new MinimalTree();
        tree.makeMinimal(arr);
        System.out.println(tree);
    }
}
