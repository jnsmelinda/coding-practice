package leetcode.p501_find_mode_in_bst;

import java.util.*;

public class FindModeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        System.out.println(Arrays.toString(findMode2(root)));
    }



//    public static int[] findMode(TreeNode root) {
//        Map<Integer, Integer> map = new TreeMap<>();
//        freqs(map, root);
//        Map<Integer, Integer> sortedMap = sortByValue(map,
//            (v1,v2) -> v2-v1);
//
//        List<Integer> list = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
//            if (list.isEmpty() || sortedMap.get(list.get(0)).equals(entry.getValue())) {
//                list.add(entry.getKey());
//            }
//            else {
//                break;
//            }
//        }
//
//        return list.stream().mapToInt(Integer::intValue).toArray();
//    }

    public static int[] findMode2(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        freqs(map, root);

        int maxValue = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue)
                list.add(entry.getKey());
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            result[i++] = e;
        }

        return result;
    }

    private static void freqs(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) {
            return;
        }
        if (!(map.containsKey(root.val))) {
            map.put(root.val, 0);
        }
        map.put(root.val, map.get(root.val) + 1);
        freqs(map, root.left);
        freqs(map, root.right);
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
