package leetcode.p540_subarray_sum_equals_k;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1,2,0,1,4};
        System.out.println(subArraySum(arr, 2));
    }

    public static int subArraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }

        return count;
    }
}
