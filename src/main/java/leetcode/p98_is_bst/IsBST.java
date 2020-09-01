package leetcode.p98_is_bst;

import java.util.ArrayList;
import java.util.List;

public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValid(root));
    }

    public static boolean isValid(TreeNode root) {
        return help(root, null, null);
    }

    public static boolean help(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        else if (min != null && root.val <= min || max != null && root.val >= max) {
            return false;
        }

        return help(root.left, min, root.val) && help(root.right, root.val, max);
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
