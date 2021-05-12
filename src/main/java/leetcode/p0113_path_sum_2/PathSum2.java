package leetcode.p0113_path_sum_2;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        tree.right = new TreeNode(8);
        tree.right.right = new TreeNode(4);
        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);
        tree.right.left = new TreeNode(13);

        System.out.println(pathSum(tree, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), paths);

        return paths;
    }

    public static void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            paths.add(current);
            return;
        }

        findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), paths);
        findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), paths);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;this.left = left;
            this.right = right;
        }
    }
}
