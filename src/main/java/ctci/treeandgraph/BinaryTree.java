package ctci.treeandgraph;

public class BinaryTree {
    public TreeNode root;
    private int size;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(int[] arr){
        for (int element : arr) {
            add(element);
            size++;
        }
    }

    public BinaryTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        root = buildTree(1, max);
    }

    public TreeNode makeMinimal(TreeNode[] arr) {
        root = makeMinimal(arr, 0, arr.length - 1);
        return root;
    }

    private TreeNode makeMinimal(TreeNode[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = arr[middle];
        root.left = makeMinimal(arr, start, middle - 1);
        root.right = makeMinimal(arr, middle + 1, end);

        return root;
    }

    private TreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            size++;
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

    public int getSize(){
        return size;
    }

    public int size(TreeNode root) {
        if (root != null) {
            return size(root.left) + size(root.right) + 1;
        }
        else {
            return 0;
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        int[] arr = {2,6,5,2,1,9,0,4,8};
        BinaryTree tree = new BinaryTree(arr);
        tree.printSideways();
        System.out.println(tree.size(tree.root.left));
    }
}
