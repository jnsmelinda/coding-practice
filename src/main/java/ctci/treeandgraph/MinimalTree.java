package ctci.treeandgraph;

public class MinimalTree {

    public static TreeNode root;

    public MinimalTree(int[] arr) {
        root = makeMinimal(arr, 0, arr.length - 1);
    }

    private static TreeNode makeMinimal(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(arr[middle]);
        root.left = makeMinimal(arr, start, middle - 1);
        root.right = makeMinimal(arr, middle + 1, end);

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
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MinimalTree tree = new MinimalTree(arr);
        tree.printSideways();
    }
}
