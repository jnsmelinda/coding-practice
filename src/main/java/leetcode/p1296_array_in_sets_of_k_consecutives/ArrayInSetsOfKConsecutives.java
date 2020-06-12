package leetcode.p1296_array_in_sets_of_k_consecutives;

import java.util.*;

public class ArrayInSetsOfKConsecutives {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5,6};
        System.out.println(isPossibleDivide(arr,4));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if ((nums.length == 0) || (k < 1) || (nums.length % k != 0)) {
            return false;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        Map <Integer,Integer> map = new HashMap<>();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        for (int n: nums) {
            if (map.get(n) == 0) continue;
            else {
                int counter = 0;
                while (counter < k) {
                    if (map.getOrDefault(n + counter, 0) == 0) {
                        return false;
                    }
                    map.put(n+counter, map.get(n+counter) - 1);
                    counter++;
                    System.out.println(map);
                }
            }
        }
        return true;
    }
}
