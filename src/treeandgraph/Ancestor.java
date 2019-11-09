package treeandgraph;

public class Ancestor {

    public static TreeNode ancestor(TreeNode root, TreeNode node1, TreeNode node2) {
        return ancestor2(root, node1, node2);
    }

    private static TreeNode ancestor2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        boolean node1OnLeft = contains(root.left, node1);
        boolean node2OnLeft = contains(root.left, node2);
        if (node1OnLeft != node2OnLeft) {
            return root;
        }
        TreeNode childSide = node1OnLeft ? root.left : root.right;
        return ancestor2(childSide, node1, node2);
    }

    private static boolean contains(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return contains(root.left, node) || contains(root.right, node);
    }

    public static void main(String[] args) {
        int [] arr = {6,1,9,5,7,2,0};
        TreeNode test1 = new TreeNode(0);
        TreeNode test2 = new TreeNode(7);
        TreeNode[] arr2 = {new TreeNode(6), new TreeNode(1), new TreeNode(9), new TreeNode(5), test2,
                new TreeNode(2), test1};
        BinaryTree tree = new BinaryTree();
        tree.makeMinimal(arr2);
        System.out.println(ancestor(tree.root, test1, test2).data);
        tree.printSideways();
    }
}
