package leetcode.p0532_k_diff_pairs_in_array;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {
    public static void main(String[] args) {
        int[] num = {1,3,1,5,4,1,1};
        System.out.println(findPairs(num, 2));
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if ((k != 0 && map.containsKey(entry.getKey() + k)) || (k == 0 && entry.getValue() > 1)) {
                count++;
            }
        }

        return count;
    }
}
