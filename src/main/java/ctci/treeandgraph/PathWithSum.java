package ctci.treeandgraph;

public class PathWithSum {

    public static int limitPath(TreeNode root, int limit) {
        if (root == null) {
            return 0;
        }
        int route = nodePathLimit(root, limit, 0);

        int leftPath = limitPath(root.left, limit);
        int rightPath = limitPath(root.right, limit);

        return leftPath + rightPath + route;
    }

    private static int nodePathLimit(TreeNode node, int limit, int counter) {
        if (node == null) {
            return 0;
        }
        counter += node.data;
        int totalPath = 0;
        if (counter == limit) {
            totalPath++;
        }
        totalPath += nodePathLimit(node.left, limit, counter);
        totalPath += nodePathLimit(node.right, limit, counter);

        return totalPath;
    }

    public static void main(String[] args) {
        int [] arr = {6,1,9,5,3,7,2,1};
        BinaryTree tree = new BinaryTree(arr);
        tree.printSideways();
        System.out.println(limitPath(tree.root, 8));
    }
}
