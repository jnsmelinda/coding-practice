package leetcode.p114_flatten_binary_tree_to_linked_list;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        flatten(root, queue);
        TreeNode node = queue.poll();
        while (!queue.isEmpty()){
            node.right = queue.poll();
            node.left = null;
            node = node.right;
        }
    }

    private static void flatten(TreeNode root, Queue<TreeNode> queue){
        if (root == null) return;
        queue.offer(root);
        flatten(root.left, queue);
        flatten(root.right, queue);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


