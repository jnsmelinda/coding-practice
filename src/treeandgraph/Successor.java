package treeandgraph;

public class Successor {

    public static TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return leftMost(node);
        }

        TreeNode temp = node;
        TreeNode x = temp.parent;
        while (x != null && x.left != temp) {
            temp = x;
            x = x.parent;
        }

        System.out.println(x.data);
        return x;
    }

    private static TreeNode leftMost(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
    }
}
