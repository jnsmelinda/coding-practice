package leetcode.p98_is_bst;

import java.util.ArrayList;
import java.util.List;

public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(isValid(root));
    }

    public static boolean isValid(TreeNode root) {
        return help(root);
    }

    public static boolean help(TreeNode root) {
        if (root.left != null) {
            if (root.left.val <= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val) {
                return false;
            }
        }
        else {
            help(root.left);
            help(root.right);
        }

        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> result = inorderTraversal(root);

        for (int i = 1; i < result.size(); i++) {
            if (result.get(i-1) >= result.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper(result, root);
    }

    public static List<Integer> helper(List<Integer> result, TreeNode root) {
        if(root == null) {
            return result;
        }
        else {
            helper(result, root.left);
            result.add(root.val);
            helper(result, root.right);
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
