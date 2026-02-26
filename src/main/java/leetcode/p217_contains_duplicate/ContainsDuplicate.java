package leetcode.p217_contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (seen.contains(nums[i])) {
                return true;
            }
            else {
                seen.add(nums[i]);
            }
        }

        return false;
    }

}
