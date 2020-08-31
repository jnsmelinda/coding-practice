package leetcode.p145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper(result, root);
    }

    public static List<Integer> helper(List<Integer> result, TreeNode root) {
        if(root == null) {
            return result;
        }
        else {
            helper(result, root.left);
            helper(result, root.right);
            result.add(root.val);
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
