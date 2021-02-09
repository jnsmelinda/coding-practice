package leetcode.p154_find_minimum_in_rotated_sorted_array_2;

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }
        }

        return min;
    }
}
