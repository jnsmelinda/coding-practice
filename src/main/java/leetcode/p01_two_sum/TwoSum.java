package leetcode.p01_two_sum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,3};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    counter = 1;
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            if (counter == 1) {
                break;
            }
        }

        return result;
    }
}
