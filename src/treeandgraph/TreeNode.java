package treeandgraph;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode(int data) {
        this(data, null, null);
    }
}
