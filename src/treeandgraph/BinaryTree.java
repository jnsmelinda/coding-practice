package treeandgraph;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree(int[] arr){
        for (int element : arr) {
            add(element);
        }
    }

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

    public void add(int value) {
        root = add(root, value);
    }

    private TreeNode add(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else if (value <= root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(2);
        tree.add(6);
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(0);
        tree.add(4);
        tree.add(8);
        tree.printSideways();
    }
}
