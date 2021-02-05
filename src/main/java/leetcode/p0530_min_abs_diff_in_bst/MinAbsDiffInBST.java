package leetcode.p0530_min_abs_diff_in_bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinAbsDiffInBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);;

        System.out.println(node);
    }

    public static int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }

        return min;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
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

        @Override
        public String toString() {
            return val + "->" + left + "->" + right;
        }
    }
}
