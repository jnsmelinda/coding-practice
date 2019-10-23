package treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepth {

    public ArrayList<LinkedList<Integer>> createLevelLinkedList(BinaryTree tree) {
        TreeNode root = tree.root;
        if (root == null) {
            return null;
        }
        ArrayList<LinkedList<Integer>> result = new ArrayList();
        createLevelLinkedList(root, result, 0);
        return result;
    }

    private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> list;
        if (result.size() == level) {
            list = new LinkedList<>();
            result.add(list);
        } else {
            list = result.get(level);
        }
        list.add(root.data);

        createLevelLinkedList(root.left, result, level + 1);
        createLevelLinkedList(root.right, result, level + 1);
    }

    public static void main(String[] args) {
        ListOfDepth lists = new ListOfDepth();
        BinaryTree tree = new BinaryTree(10);
        tree.printSideways();
        System.out.println(lists.createLevelLinkedList(tree));
    }
}
