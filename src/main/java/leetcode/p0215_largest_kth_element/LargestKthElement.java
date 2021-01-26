package leetcode.p0215_largest_kth_element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestKthElement {
    public static void main(String[] args) {
        int[] arr = {5,7,2,5,3,6};
        System.out.println(findKthLargest(arr, 3));
    }

    public static int findKthLargest(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i< nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list);
        Collections.reverse(list);

        return list.get(k-1);
    }
}
