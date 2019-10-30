package treeandgraph;

public class SubTree {

    public static boolean isSubTree(TreeNode node1, TreeNode node2) {
        StringBuilder list1 = new StringBuilder();
        StringBuilder list2 = new StringBuilder();

        getLists(node1, list1);
        getLists(node2, list2);

        return list1.indexOf(list2.toString()) != -1;
    }

    private static void getLists(TreeNode node, StringBuilder list) {
        if (node == null) {
            list.append("null");
            return;
        }
        list.append(node.data);
        getLists(node.left, list);
        getLists(node.right, list);
    }

    public static void main(String[] args) {
        int[] arr = {10, 11, 6, 7, 2, 18};
        BinaryTree tree1 = new BinaryTree(arr);
        int[] arr2 = {6,7,2};
        BinaryTree tree2 = new BinaryTree(arr2);
        tree1.printSideways();
        tree2.printSideways();
        System.out.println(isSubTree(tree1.root, tree2.root));
    }
}
