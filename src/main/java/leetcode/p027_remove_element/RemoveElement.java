package leetcode.p027_remove_element;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr,2));
    }

    public static int removeElement(int[] nums, int val) {
        int removed = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                removed++;
            } else {
                nums[i - removed] = nums[i];
            }
        }

        return nums.length - removed;
    }
}
