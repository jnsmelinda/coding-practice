package leetcode.p3462_maximum_sum_with_at_most_k_elements;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] grid = {{3},{9},{1}};
        int[] limits = {1,0,0};
        int k = 1;

        System.out.println(maxSum(grid, limits, k));
    }

    public static long maxSum(int[][] grid, int[] limits, int k) {
        if (k == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            if (limits[i] == 0){
                continue;
            }
            Arrays.sort(grid[i]);
            List<Integer> currentList = new ArrayList<>();
            for (int j = grid[i].length - 1; j >= 0; j--) {
                currentList.add(grid[i][j]);
                if (currentList.size() == limits[i]) {
                    break;
                }
            }

            list.addAll(currentList);
        }

        Collections.sort(list, Collections.reverseOrder());

        long sum = 0;
        int inc = 0;
        for (Integer num : list) {
            sum += num;
            inc++;
            if (inc == k){
                return sum;
            }
        }

        return sum;
    }
}
