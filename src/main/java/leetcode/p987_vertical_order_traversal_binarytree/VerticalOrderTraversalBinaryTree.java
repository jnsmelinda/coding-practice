package leetcode.p987_vertical_order_traversal_binarytree;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {
    public static void main(String[] args) {
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Map <Integer,List<Integer>> map = new TreeMap<>();
        makeMap(root, map, 0);
        for (List<Integer> x : map.values()) {
            Collections.sort(x);
            list.add(x);
        }

        return list;
    }

    public void makeMap(TreeNode root, Map<Integer,List<Integer>> map, int index) {
        if (root != null) {
            if(!map.containsKey(index)) {
                map.put(index, new ArrayList<>());
            }
            List<Integer> list = map.get(index);
            list.add(root.val);
            map.put(index, list);

            makeMap(root.left,map,index-1);
            makeMap(root.right,map,index+1);
        }
    }

    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

}
