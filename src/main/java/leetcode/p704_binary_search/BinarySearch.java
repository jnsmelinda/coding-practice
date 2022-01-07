package leetcode.p704_binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }
    public static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        return bs(nums, target, begin, end);
    }

    private static int bs(int[] nums, int target, int begin, int end){
        int mid = (end + begin) / 2;

        if (end < begin) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        }
        else if (target < nums[mid]) {
            return bs(nums, target, begin, mid - 1);
        }
        else if (target > nums[mid]) {
            return bs(nums, target, mid + 1, end);
        }

        return -1;
    }
}
