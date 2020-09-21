package leetcode.p128_longest_consecutive_sequence;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr1 = {0,0};
        int[] arr2 = {1,2,0,1};
        int[] arr3 = {0};
        int[] arr4 = {9,1,4,7,3,-1,0,5,8,-1,6};

        System.out.println(longestConsecutive(arr4));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int sequence = 1;
        int maxS = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                sequence++;
            }
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] + 2 <= nums[i]) {
                sequence = 1;
            }
            if (sequence > maxS) {
                maxS = sequence;
            }
        }

        return maxS;
    }
}
