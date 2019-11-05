package treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepth {

    public ArrayList<LinkedList<Integer>> createLevelLinkedList(BinaryTree tree) {
        TreeNode root = tree.root;
        if (root == null) {
            return null;
        }
        ArrayList<LinkedList<Integer>> levels = new ArrayList();
        createLevelLinkedList(root, levels, 0);
        return levels;
    }

    private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<Integer>> levels, int level) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        if (levels.size() == level) {
            levels.add(list);
        }
        list = levels.get(level);
        list.add(root.data);

        createLevelLinkedList(root.left, levels, level + 1);
        createLevelLinkedList(root.right, levels, level + 1);
    }

    public static void main(String[] args) {
        ListOfDepth lists = new ListOfDepth();
        BinaryTree tree = new BinaryTree(10);
        tree.printSideways();
        System.out.println(lists.createLevelLinkedList(tree));
    }
}
