package treeandgraph;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int data;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.parent = null;
    }

    public TreeNode(int data) {
        this(data, null, null);
    }
}
