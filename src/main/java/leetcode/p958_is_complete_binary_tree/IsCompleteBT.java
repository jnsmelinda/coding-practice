package leetcode.p958_is_complete_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, new LinkedList<>());
    }

    private static boolean helper(TreeNode root, Queue<TreeNode> q) {
        q.add(root);
        boolean endFlag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                TreeNode n = q.poll();
                if (endFlag && (n.left != null || n.right != null)) {
                    return false;
                }
                if (n.right != null && n.left == null) {
                    return false;
                }
                else if (n.left != null && n.right == null) {
                    q.add(n.left);
                    endFlag = true;
                }
                else if (n.left != null && n.right != null) {
                    q.add(n.left);
                    q.add(n.right);
                }
                else {
                    endFlag = true;
                }

                size--;
            }
        }

        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode root;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.root.val = val;
             this.root.left = left;
              this.root.right = right;
        }
    }
}
